CREATE OR REPLACE PROCEDURE GetParkingRanking(startDate IN DATE, endDate IN DATE) AS
BEGIN
    SELECT placa, modelo, cliente, tempo_decorrido, valor, RANK() OVER (ORDER BY tempo_decorrido) AS posicao_rank
    FROM (
        SELECT placa, modelo, cliente, (saida - entrada) AS tempo_decorrido, valor
        FROM reservas
        WHERE status = 'F' AND entrada BETWEEN startDate AND endDate
    )
    ORDER BY tempo_decorrido;
END;