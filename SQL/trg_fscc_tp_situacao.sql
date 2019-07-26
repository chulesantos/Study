CREATE OR REPLACE TRIGGER TRG_FSCC_TP_SITUACAO
  AFTER UPDATE ON DBAMV.TB_AVISO_CIRURGIA
  FOR EACH ROW

DECLARE

  EMAIL       LONG;
  VR_ERRO_MSG VARCHAR2(1000);
  ASSUNTO     VARCHAR2(500);
  USERLOGADO  VARCHAR2(50);

BEGIN

  IF (:NEW.SN_CONFIRMADO = 'S') AND (:NEW.TP_SITUACAO NOT IN ('R', 'C')) THEN

    USERLOGADO := 'DBAMV';
    ASSUNTO    := 'Aviso confirmado. UPDATE na coluna "TP_SITUACAO", novo valor = "' || :NEW.TP_SITUACAO || '"';
    EMAIL      := '';

EMAIL := '<!DOCTYPE html> <!-- HTML5 -->';

EMAIL := EMAIL || '<html style = "margin: 0; padding: 0; border: 0; font-size: 100%; font: inherit; vertical-align: baseline;">';
EMAIL := EMAIL || '<head>';
EMAIL := EMAIL || '<meta charset="UTF-8">';
EMAIL := EMAIL || '</head>';
EMAIL := EMAIL || '<body style = "margin: 0; padding: 0; border: 0; font-size: 100%; font: inherit; vertical-align: baseline; line-height: 1; font-family: Helvetica, Arial, sans-serif; font-size: 14px;">';

EMAIL := EMAIL || '<header style="display: block; background-color: #333; height: 3em; color: #FFF; margin-bottom: 1em; margin: 0; padding: 0; border: 0; font-size: 100%; font: inherit; vertical-align: baseline;">';
EMAIL := EMAIL || '<div style="content: ''; display:inline-block; height: 100%; vertical-align: middle; margin-left: 20%;">';
EMAIL := EMAIL || '<h1 style="font-size: 2em; display:inline-block; vertical-align:	middle; margin-top: 8px; margin-left: 20%;">ROTINA AUTOMATICA - MV2000</h1>';
EMAIL := EMAIL || '</div>';
EMAIL := EMAIL || '</header>';

EMAIL := EMAIL || '<main>';
EMAIL := EMAIL || '<section style="margin: 2em 0; overflow: hidden; width: 60%; height: 100%; margin: 0 auto;">';
EMAIL := EMAIL || '<p>';
EMAIL := EMAIL || '<strong>Mensagem:</strong> ' || ASSUNTO;
EMAIL := EMAIL || '<p>';
EMAIL := EMAIL || '<h2 style="font-size: 1em; display: block; padding-bottom: .5em; border-bottom: 1px solid #ccc; margin-bottom: .5em;">DADOS DO AVISO</h2>';

EMAIL := EMAIL || '<table style="border-collapse: collapse; border-spacing: 0; width: 100%; margin-bottom : .5em; table-layout: fixed;">';
EMAIL := EMAIL || '<thead>';
EMAIL := EMAIL || '<tr>';


/* BEGIN NOME DAS COLUNAS */

EMAIL := EMAIL || '<th style="padding: .7em; margin: 0; border: 1px solid #ccc; text-align: center; font-weight: bold; background-color: #EEE;">CD_AVISO</th>';
EMAIL := EMAIL || '<th style="padding: .7em; margin: 0; border: 1px solid #ccc; text-align: center; font-weight: bold; background-color: #EEE;">USER_CONFIRMA</th>';
EMAIL := EMAIL || '<th style="padding: .7em; margin: 0; border: 1px solid #ccc; text-align: center; font-weight: bold; background-color: #EEE;">USER_SESSION</th>';
EMAIL := EMAIL || '<th style="padding: .7em; margin: 0; border: 1px solid #ccc; text-align: center; font-weight: bold; background-color: #EEE;">DATA / HORA</th>';

/* END NOME DAS COLUNAS */

EMAIL := EMAIL || '</tr>';
EMAIL := EMAIL || '</thead>';
EMAIL := EMAIL || '<tbody>';
EMAIL := EMAIL || '<tr>';


/* BEGIN VALORES DAS COLUNAS */

EMAIL := EMAIL || '<td style="padding: .7em; margin: 0; border: 1px solid #ccc; text-align: center;">'|| :NEW.CD_AVISO_CIRURGIA || '</td>';
EMAIL := EMAIL || '<td style="padding: .7em; margin: 0; border: 1px solid #ccc; text-align: center;">'|| :NEW.CD_USUARIO_CONFIRMA || '</td>';
EMAIL := EMAIL || '<td style="padding: .7em; margin: 0; border: 1px solid #ccc; text-align: center;">'|| USERLOGADO || '</td>';
EMAIL := EMAIL || '<td style="padding: .7em; margin: 0; border: 1px solid #ccc; text-align: center;">'|| TO_CHAR(SYSDATE, 'DD/MM/YYYY HH24:MI:SS') || '</td>';

/* END VALORES DAS COLUNAS */

EMAIL := EMAIL || '</tr>';
EMAIL := EMAIL || '</tbody>';
EMAIL := EMAIL || '</table>';

EMAIL := EMAIL || '<h4 style="margin-top: 10%;">Quaisquer dúvidas entrar contato o setor de Tecnologia da Informacao.</h4>';
EMAIL := EMAIL || '<h5>E-mail: sistemas@vah.com.br</h5>';
EMAIL := EMAIL || '<h5>Ramal: 5550 </h5>';

EMAIL := EMAIL || '</section>';
EMAIL := EMAIL || '</main>';
EMAIL := EMAIL || '</body>';
EMAIL := EMAIL || '</html>';


    BEGIN

      USRDBVAH.PRCSENDMAIL_LONG('mvprod@vah.com.br',
                                'sistemas@vah.com.br',
                                ASSUNTO,
                                EMAIL,
                                1,
                                NULL,
                                NULL,
                                NULL,
                                NULL,
                                NULL);

    EXCEPTION

      WHEN NO_DATA_FOUND THEN
        VR_ERRO_MSG := TRIM(SUBSTR(SQLERRM, 1, 1000));
        INSERT INTO TB_AVISOS_ERROS
          (OBJETO, TIPO, DATA, ASSUNTO_ERRO, EMAIL)
        VALUES
          ('TRG_FSCC_TP_SITUACAO', 'TRIGGER', SYSDATE, VR_ERRO_MSG, '');

      WHEN OTHERS THEN
        VR_ERRO_MSG := TRIM(SUBSTR(SQLERRM, 1, 1000));
        INSERT INTO TB_AVISOS_ERROS
          (OBJETO, TIPO, DATA, ASSUNTO_ERRO, EMAIL)
        VALUES
          ('TRG_FSCC_TP_SITUACAO', 'TRIGGER', SYSDATE, VR_ERRO_MSG, '');

    END;

  END IF;

END TRG_FSCC_TP_SITUACAO;
