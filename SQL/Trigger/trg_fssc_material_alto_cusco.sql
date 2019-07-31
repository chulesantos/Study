CREATE OR REPLACE TRIGGER TRG_FSCC_MATERIAL_ALTO_CUSTO
  AFTER INSERT OR DELETE ON DBAMV.ITMVTO_ESTOQUE
  FOR EACH ROW

DECLARE

        vr_erro_msg VARCHAR2(2000);

  EMAIL           LONG;
  MSG             VARCHAR2(500);
  VAR_AVISO       DBAMV.AVISO_CIRURGIA.CD_AVISO_CIRURGIA%TYPE;
  VAR_CONFIRMADO  DBAMV.AVISO_CIRURGIA.SN_CONFIRMADO%TYPE;
  VAR_TP_MVTO     DBAMV.MVTO_ESTOQUE.TP_MVTO_ESTOQUE%TYPE;
  VAR_PRODUTO     DBAMV.PRODUTO.CD_PRODUTO%TYPE;
  VAR_CD_MVTO     DBAMV.MVTO_ESTOQUE.CD_MVTO_ESTOQUE%TYPE;
  VAR_CD_PRO_FAT  DBAMV.PRO_FAT.CD_PRO_FAT%TYPE;
  VAR_DS_PRO_FAT  DBAMV.PRO_FAT.DS_PRO_FAT%TYPE;
  VAR_ATENDIMENTO DBAMV.TB_ATENDIME.CD_ATENDIMENTO%TYPE;
  VAR_PRONTUARIO  DBAMV.PACIENTE.CD_PACIENTE%TYPE;
  VAR_PACIENTE    DBAMV.PACIENTE.NM_PACIENTE%TYPE;
  VAR_UNIDADE     DBAMV.UNID_INT.DS_UNID_INT%TYPE;
  VAR_LEITO       DBAMV.LEITO.DS_LEITO%TYPE;
  VAR_PRESTADOR   DBAMV.PRESTADOR.NM_PRESTADOR%TYPE;

BEGIN

  IF INSERTING THEN
    VAR_PRODUTO := :NEW.CD_PRODUTO;
    VAR_CD_MVTO := :NEW.CD_MVTO_ESTOQUE;
    MSG      := 'LANCAMENTO [GASTO DE SALA]';

  ELSIF DELETING THEN
    VAR_PRODUTO := :OLD.CD_PRODUTO;
    VAR_CD_MVTO := :OLD.CD_MVTO_ESTOQUE;
    MSG      := 'EXCLUSAO [GASTO DE SALA]';

  END IF;

  BEGIN

  SELECT

   AVIS.CD_AVISO_CIRURGIA,
   AVIS.SN_CONFIRMADO,
   MVTO.TP_MVTO_ESTOQUE,
   AVIS.CD_AVISO_CIRURGIA,
   PF.CD_PRO_FAT,
   PF.DS_PRO_FAT,
   AVIS.CD_ATENDIMENTO,
   AVIS.CD_PACIENTE,
   PAC.NM_PACIENTE,
   UNID.DS_UNID_INT,
   LEI.DS_LEITO,
   PREST.NM_PRESTADOR

    INTO VAR_AVISO,
    VAR_CONFIRMADO,
    VAR_TP_MVTO,
    VAR_AVISO,
    VAR_CD_PRO_FAT,
    VAR_DS_PRO_FAT,
    VAR_ATENDIMENTO,
    VAR_PRONTUARIO,
    VAR_PACIENTE,
    VAR_UNIDADE,
    VAR_LEITO,
    VAR_PRESTADOR

    FROM DBAMV.MVTO_ESTOQUE MVTO

    JOIN DBAMV.AVISO_CIRURGIA AVIS
      ON AVIS.CD_AVISO_CIRURGIA = MVTO.CD_AVISO_CIRURGIA

      JOIN PRESTADOR_AVISO PA
      ON PA.CD_AVISO_CIRURGIA = AVIS.CD_AVISO_CIRURGIA
      AND PA.SN_PRINCIPAL = 'S'

      JOIN PRESTADOR PREST
      ON PREST.CD_PRESTADOR = PA.CD_PRESTADOR

      JOIN ATENDIME ATEN
      ON ATEN.CD_ATENDIMENTO = AVIS.CD_ATENDIMENTO

      JOIN LEITO LEI
      ON LEI.CD_LEITO = ATEN.CD_LEITO

      JOIN UNID_INT UNID
      ON UNID.CD_UNID_INT = LEI.CD_UNID_INT

      JOIN PACIENTE PAC
      ON PAC.CD_PACIENTE = AVIS.CD_PACIENTE

    JOIN DBAMV.PRODUTO PROD
      ON PROD.CD_PRODUTO = VAR_PRODUTO

    JOIN DBAMV.PRO_FAT PF
      ON PF.CD_PRO_FAT = PROD.CD_PRO_FAT

   WHERE MVTO.CD_MVTO_ESTOQUE = VAR_CD_MVTO;

   EXCEPTION
      WHEN NO_DATA_FOUND THEN
   VAR_AVISO := NULL;
    VAR_CONFIRMADO := NULL;
    VAR_TP_MVTO := NULL;
    VAR_AVISO := NULL;
    VAR_CD_PRO_FAT := NULL;
    VAR_DS_PRO_FAT := NULL;
    VAR_ATENDIMENTO := NULL;
    VAR_PRONTUARIO := NULL;
    VAR_PACIENTE := NULL;
    VAR_UNIDADE := NULL;
    VAR_LEITO := NULL;
    VAR_PRESTADOR := NULL;

      WHEN OTHERS THEN
    VAR_AVISO := NULL;
    VAR_CONFIRMADO := NULL;
    VAR_TP_MVTO := NULL;
    VAR_AVISO := NULL;
    VAR_CD_PRO_FAT := NULL;
    VAR_DS_PRO_FAT := NULL;
    VAR_ATENDIMENTO := NULL;
    VAR_PRONTUARIO := NULL;
    VAR_PACIENTE := NULL;
    VAR_UNIDADE := NULL;
    VAR_LEITO := NULL;
    VAR_PRESTADOR := NULL;
--TRG_AVI_CIR_A_UPD
    END;

   /*
   07025627 - TISSEEL LYO 4ML
   07025625 - TISSEEL LYO 2ML
   */

  IF ((VAR_CD_PRO_FAT IN ('07025627', '07025625')) AND (VAR_TP_MVTO = 'P') AND (VAR_AVISO IS NOT NULL)) THEN

    EMAIL := '  <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> ' ||
             '  <html> ' || '  <head> ' ||
             '    <meta content="text/html; charset=ISO-8859-1" ' ||
             '   http-equiv="content-type"> ' || '  </head> ' ||
             '  <body> ' ||
             '  <table style="width: 100%; height: 32px;" border="1" ' ||
             '   cellpadding="2" cellspacing="1"> ' || '   <tbody> ' ||
             '      <tr> ' ||
             '        <td style="font-family: Tahoma; font-weight: bold;"> <h1>'|| MSG || ' - PROCEDIMENTO DE ALTO CUSTO<h1>' ||
             '        </td>' || '      </tr> ' || '    </tbody> ' ||
             '  </table> ' || '  <br> ' ||
             '  <table style="width: 100%; height: 32px;" border="1" ' ||
             '   cellpadding="2" cellspacing="1"> ' || '    <tbody> ' ||
             '      <tr> ' || '        <td ' ||
             '   style="width: 20%; text-align: right; font-weight: bold; font-family: Tahoma;"><small>Prontuario/Atendimento</small></td> ' ||
             '       <td style="font-family: Tahoma;"><small>' ||
             VAR_PRONTUARIO || '/' || VAR_ATENDIMENTO ||
             '</small></td> ' || '      </tr> ' || '      <tr> ' ||
             '        <td ' ||
             '   style="width: 20%; text-align: right; font-weight: bold; font-family: Tahoma;"><small>Nome do Paciente</small></td> ' ||
             '       <td style="font-family: Tahoma;"><small>' ||
             VAR_PACIENTE || '</small></td> ' || '      </tr> ' ||
             '      <tr> ' || '        <td ' ||
             '   style="width: 20%; text-align: right; font-weight: bold; font-family: Tahoma;"><small>Unidade/ Leito</small></td> ' ||
             '       <td style="font-family: Tahoma;"><small>' ||
             VAR_UNIDADE || ' - ' || VAR_LEITO || '</small></td> ' ||
             '      </tr> ' || '      </tr> ' || '      <tr> ' ||
             '        <td ' ||
             '   style="width: 20%; text-align: right; font-weight: bold; font-family: Tahoma;"><small>Cirurgiao Solicitante</small></td> ' ||
             '       <td style="font-family: Tahoma;"><small>' ||
             VAR_PRESTADOR || '</small></td> ' || '      </tr> ' ||
             '      </tr> ' || '      <tr> ' || '        <td ' ||
             '   style="width: 20%; text-align: right; font-weight: bold; font-family: Tahoma;"><small>Codigo Procedimento</small></td> ' ||
             '       <td style="font-family: Tahoma;"><small>' ||
             VAR_CD_PRO_FAT || '</small></td> ' || '      </tr> ' ||
             '      <tr> ' || '</small></td> ' || '      </tr>

             <tr> ' || '        <td ' ||
             '   style="width: 20%; text-align: right; font-weight: bold; font-family: Tahoma;"><small>Procedimento</small></td> ' ||
             '       <td style="font-family: Tahoma;"><small>' ||
             VAR_DS_PRO_FAT || '</small></td> ' || '      </tr> ' ||
             '      <tr> ' || '</small></td> ' || '      </tr> ' ||

             ' <tr> ' || '        <td ' ||
             '   style="width: 20%; text-align: right; font-weight: bold; font-family: Tahoma;"><small>Data/Hora Movimentacao</small></td> ' ||
             '       <td style="font-family: Tahoma;"><small>' ||
             SYSDATE || '</small></td> ' || '      </tr> ' ||
             '      <tr> ' || '</small></td> ' || '      </tr>' ||



             '</tbody> ' ||
             '  </table> ' || ' <br> ' || '  </body> ' || '  </html> ';

    BEGIN

         USRDBVAH.PRCSENDMAIL_LONG('mvprod@vah.com.br',
      'chulesantos@vah.com.br',
      MSG || ' - PROCEDIMENTO DE ALTO CUSTO',
      EMAIL,
      1,
      NULL,
      NULL,
      NULL,
      NULL,
      NULL);

           USRDBVAH.PRCSENDMAIL_LONG('mvprod@vah.com.br',
      'faturamento@vah.com.br',
      MSG || ' - PROCEDIMENTO DE ALTO CUSTO',
      EMAIL,
      1,
      NULL,
      NULL,
      NULL,
      NULL,
      NULL);

           USRDBVAH.PRCSENDMAIL_LONG('mvprod@vah.com.br',
      'autorizadores@vah.com.br',
      MSG || ' - PROCEDIMENTO DE ALTO CUSTO',
      EMAIL,
      1,
      NULL,
      NULL,
      NULL,
      NULL,
      NULL);

    EXCEPTION

      WHEN NO_DATA_FOUND THEN
        vr_erro_msg := trim(substr(sqlerrm, 1, 1000));
        INSERT INTO TB_AVISOS_ERROS
          (OBJETO, TIPO, DATA, ASSUNTO_ERRO, EMAIL)
        VALUES
          ('TRG_FSCC_MATERIAL_ALTO_CUSTO',
           'TRIGGER',
           SYSDATE,
           vr_erro_msg,
           '');


      WHEN OTHERS THEN
        vr_erro_msg := trim(substr(sqlerrm, 1, 1000));
      INSERT INTO TB_AVISOS_ERROS
          (OBJETO, TIPO, DATA, ASSUNTO_ERRO, EMAIL)
        VALUES
          ('TRG_FSCC_MATERIAL_ALTO_CUSTO',
           'TRIGGER',
           SYSDATE,
           vr_erro_msg,
           '');

    END;

  END IF;

END TRG_FSCC_MATERIAL_ALTO_CUSTO;
