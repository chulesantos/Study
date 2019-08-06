CREATE OR REPLACE VIEW VDIC_LIBERACAO_PRESCRICAO AS
SELECT

 K.COMPETENCIA,
 K.ANO,
 K.MES,
 CASE
   WHEN K.PREST_ATEND = 'S' THEN
    'MEDICO_PACIENTE'
   ELSE
    'NAO_MEDICO_PACIENTE'
 END TIPO_PRESCRICAO,
 (SELECT P.NM_PRESTADOR
    FROM PRESTADOR P
   WHERE P.CD_PRESTADOR = K.CD_PRESTADOR) PRESTADOR,
 (SELECT E.DS_ESPECIALID
    FROM ESPECIALID E
   WHERE E.CD_ESPECIALID = K.CD_ESPECIALID) ESPECIALIDADE,
 SUM("MENOR_13HRS") "MENOR_13HRS",
 SUM("MAIOR_13HRS") "MAIOR_13HRS"

  FROM (SELECT

         W.ATENDIMENTO,
         TO_CHAR(W.DT_PRESCRICAO, 'YYYY/MM') COMPETENCIA,
         TO_CHAR(W.DT_PRESCRICAO, 'YYYY') ANO,
         TO_CHAR(W.DT_PRESCRICAO, 'MM') MES,
         W.HR_PRESCRICAO,
         W.STR,
         W.PRESC,
         W.CD_ESPECIALID,
         W.CD_PRESTADOR,
         W.PREST_ATEND,

         CASE
           WHEN W.TEMPO = '<13' THEN
            1
           ELSE
            0
         END "MENOR_13HRS",

         CASE
           WHEN W.TEMPO = '>13' THEN
            1
           ELSE
            0
         END "MAIOR_13HRS"

          FROM (SELECT

                 Z.ATENDIMENTO,
                 Z.DT_PRESCRICAO,
                 TO_CHAR(PRE.DH_IMPRESSAO, 'HH24:MI:SS') HR_PRESCRICAO,
                 Z.STR,
                 TO_NUMBER(SUBSTR(SUBSTR(Z.STR,
                                         (Z.POSICAO - 7) + 1,
                                         Z.POSICAO),1,7)) PRESC,
                 ESP.CD_ESPECIALID,
                 PRE.CD_PRESTADOR,

                 CASE
                   WHEN ATEN.CD_PRESTADOR = PRE.CD_PRESTADOR THEN
                    'S'
                   ELSE
                    'N'
                 END PREST_ATEND,

                 CASE

                   WHEN TO_CHAR(TO_CHAR(PRE.DH_IMPRESSAO, 'HH24')) = 13 AND
                        TO_CHAR(PRE.DH_IMPRESSAO, 'MI') > 00 THEN
                    '>13'

                   WHEN TO_CHAR(TO_CHAR(PRE.DH_IMPRESSAO, 'HH24')) >= 00 AND
                        TO_CHAR(PRE.DH_IMPRESSAO, 'HH24') <= 13 THEN
                    '<13'

                   WHEN TO_CHAR(PRE.DH_IMPRESSAO, 'HH24') > 13 OR
                        TO_CHAR(PRE.DH_IMPRESSAO, 'HH24') <= 23 THEN
                    '>13'
                 END TEMPO

                  FROM (SELECT

                         Y.ATENDIMENTO,
                         Y.DT_PRESCRICAO,
                         Y.STR,

                         CASE
                           WHEN TO_NUMBER(INSTR(Y.STR, 'S')) = 0 THEN
                            TO_NUMBER(INSTR(Y.STR, 'N'))
                           ELSE
                            TO_NUMBER(INSTR(Y.STR, 'S'))
                         END - 2 POSICAO

                          FROM (SELECT X.ATENDIMENTO,
                                       X.DT_PRESCRICAO,
                                       RTRIM(XMLAGG(XMLELEMENT(E, X.PRESC || '-' || X.PREST_ATEND, ',')
                                                    .EXTRACT('//text()') ORDER BY
                                                     X.PRESC),',') STR

                                  FROM (SELECT

                                         ATEN.CD_ATENDIMENTO ATENDIMENTO,
                                         PRE.CD_PRE_MED PRESC,
                                         TRUNC(PRE.DH_IMPRESSAO) DT_PRESCRICAO,
                                         PRE.CD_PRESTADOR PRESTADOR,

                                         CASE
                                           WHEN ATEN.CD_PRESTADOR =
                                                PRE.CD_PRESTADOR THEN
                                            'S'
                                           ELSE
                                            'N'
                                         END PREST_ATEND

                                          FROM PRE_MED PRE

                                          JOIN ATENDIME ATEN
                                            ON ATEN.CD_ATENDIMENTO =
                                               PRE.CD_ATENDIMENTO

                                         WHERE ATEN.TP_ATENDIMENTO = 'I'
                                           AND ATEN.CD_MULTI_EMPRESA = 1
                                           AND PRE.TP_PRE_MED = 'M'
                                           AND PRE.DH_IMPRESSAO IS NOT NULL
                                           AND PRE.CD_UNID_INT IS NOT NULL
                                           AND PRE.CD_UNID_INT NOT IN
                                               (7, 8, 9, 10, 15, 16)
                                           AND TRUNC(ATEN.DT_ATENDIMENTO) <>
                                               TRUNC(PRE.DH_IMPRESSAO)
                                           AND TO_NUMBER(TO_CHAR(PRE.DH_IMPRESSAO,'D')) NOT IN (1, 7)) X

                                 GROUP BY X.ATENDIMENTO, X.DT_PRESCRICAO) Y) Z

                  JOIN ATENDIME ATEN
                    ON ATEN.CD_ATENDIMENTO = Z.ATENDIMENTO
                   AND ATEN.TP_ATENDIMENTO = 'I'
                   AND ATEN.CD_MULTI_EMPRESA = 1

                  JOIN PRE_MED PRE
                    ON PRE.CD_PRE_MED = TO_NUMBER(SUBSTR(SUBSTR(Z.STR,
                                                                (Z.POSICAO - 7) + 1,
                                                                Z.POSICAO), 1, 7))
                   AND PRE.TP_PRE_MED = 'M'
                   AND PRE.DH_IMPRESSAO IS NOT NULL
                   AND PRE.CD_UNID_INT IS NOT NULL
                   AND PRE.CD_UNID_INT NOT IN (7, 8, 9, 10, 15, 16)
                   AND TRUNC(ATEN.DT_ATENDIMENTO) <> TRUNC(PRE.DH_IMPRESSAO)
                   AND TO_NUMBER(TO_CHAR(PRE.DH_IMPRESSAO, 'D')) NOT IN (1, 7) /*DESCONDIDERAR D 1 - DOMINGO E D 7 - SÁBADO*/

                  JOIN ESP_MED ESP
                    ON ESP.CD_PRESTADOR = PRE.CD_PRESTADOR
                   AND ESP.SN_ESPECIAL_PRINCIPAL = 'S') W) K

--WHERE K.COMPETENCIA = '2018/09'

 GROUP BY K.COMPETENCIA,
          K.ANO,
          K.MES,
          K.PREST_ATEND,
          K.CD_PRESTADOR,
          K.CD_ESPECIALID

 ORDER BY ESPECIALIDADE, PRESTADOR, TIPO_PRESCRICAO ASC
;
