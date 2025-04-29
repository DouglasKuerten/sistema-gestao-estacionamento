import React from 'react';
import { Page, Text, View, Document, Svg, Path } from '@react-pdf/renderer';
import { BsPinFill } from "react-icons/bs"

export default function DayParking() {
    const dados = [
        {
            carro: 'Gol',
            cor: 'Prata',
            cliente: 'João da Silva',
            placa: 'ABC-0025',
            dataEntrada: '01/06/2023 08:45',
            dataSaida: '01/06/2023 10:20',
            tempo: '1 hora 35 minutos',
            valor: 16.32
        },
        {
            carro: 'Civic',
            cor: 'Preto',
            cliente: 'Maria Santos',
            placa: 'DEF-1',
            dataEntrada: '02/06/2023 12:15',
            dataSaida: '02/06/2023 15:45',
            tempo: '3 horas 30 minutos',
            valor: 25.80
        },
        {
            carro: 'Onix',
            cor: 'Vermelho',
            cliente: 'Pedro Oliveira',
            placa: 'GHI-2',
            dataEntrada: '03/06/2023 09:30',
            dataSaida: '03/06/2023 11:10',
            tempo: '1 hora 40 minutos',
            valor: 18.90
        },
    ];

    const calcularTotal = (dados) => {
        let total = 0;
        dados.forEach((item) => {
            total += item.valor;
        });
        return total.toLocaleString("pt-BR", { minimumFractionDigits: 2, maximumFractionDigits: 2 });
    };



    return (
        <Document title='Relatório de Veículos'>
            <Page size="A4" style={{ flexDirection: "column", padding: 20, }}>
                {/* Cabeçalho */}
                <View style={{ flexDirection: "row", marginBottom: 5, padding: 12, border: 1, borderColor: "black", borderRadius: "10px" }}>
                    <View style={{ width: '25%', alignItems: 'center', flexDirection: 'row' }}>
                        <Svg width="40" height="40" style={{ display: 'flex', backgroundColor: '#2563eb', alignContent: 'center', borderRadius: '4px', justifyContent: 'center' }}>
                            <Path
                                fill='white'
                                transform="scale(1.5) translate(5.5%, 5.5%)"
                                d="M4.146.146A.5.5 0 0 1 4.5 0h7a.5.5 0 0 1 .5.5c0 .68-.342 1.174-.646 1.479-.126.125-.25.224-.354.298v4.431l.078.048c.203.127.476.314.751.555C12.36 7.775 13 8.527 13 9.5a.5.5 0 0 1-.5.5h-4v4.5c0 .276-.224 1.5-.5 1.5s-.5-1.224-.5-1.5V10h-4a.5.5 0 0 1-.5-.5c0-.973.64-1.725 1.17-2.189A5.921 5.921 0 0 1 5 6.708V2.277a2.77 2.77 0 0 1-.354-.298C4.342 1.674 4 1.179 4 .5a.5.5 0 0 1 .146-.354z" />
                        </Svg>
                        <Text style={{ paddingLeft: '8px', fontWeight: 500, fontSize: '20px' }}>
                            Parking
                        </Text>
                    </View>
                    <View style={{ width: '50%', alignItems: 'center', flexDirection: 'colunm', justifyContent: 'center' }}>
                        <Text style={{ fontSize: 18, fontFamily: "Helvetica-Bold", textAlign: "center" }}>Relatório de Veículos</Text>
                        <Text style={{ fontSize: 9, fontFamily: "Helvetica", textAlign: "center" }}>Período de dd/mm/yyyy até dd/mm/yyyy</Text>
                    </View>
                    <View style={{ width: '25%', alignItems: 'center', flexDirection: 'row', justifyContent: 'flex-end', fontSize: 7 }}>
                        <View style={{ fontFamily: "Helvetica-Bold", textAlign: 'right', alignItems: 'flex-end' }}>
                            <Text>Data:</Text>
                            <Text>Hora:</Text>
                            <Text>Página:</Text>
                        </View>
                        <View style={{ fontFamily: "Helvetica", textAlign: 'left', alignItems: 'center', paddingLeft: "2px" }}>
                            <Text>06/06/2023</Text>
                            <Text>12:23:43</Text>
                            <Text>01/01</Text>
                        </View>
                    </View>
                </View>

                {/* Etiquetas */}
                <View style={{ flexDirection: "row", marginBottom: 1, fontSize: 8, textDecoration: "underline", fontFamily: "Helvetica-Bold" }}>
                    <Text style={{ width: "12.5%", marginBottom: 5 }}>Data de Entrada</Text>
                    <Text style={{ width: "12.5%", marginBottom: 5 }}>Data de Saída</Text>
                    <Text style={{ width: "8%", marginBottom: 5 }}>Placa</Text>
                    <Text style={{ width: "10%", marginBottom: 5 }}>Carro</Text>
                    <Text style={{ width: "10%", marginBottom: 5 }}>Cor</Text>
                    <Text style={{ width: "21%", marginBottom: 5 }}>Cliente</Text>
                    <Text style={{ width: "16%", marginBottom: 5 }}>Tempo</Text>
                    <Text style={{ width: "10%", marginBottom: 5, textAlign: "right" }}>Valor</Text>
                </View>

                {/* Dados */}
                {dados.map((item, index) => (
                    <View wrap={false} key={index} style={{ flexDirection: "row", marginBottom: 2, fontSize: 8, fontFamily: "Helvetica" }}>
                        <Text style={{ width: "12.5%", maxLines: 1 }}>{item.dataEntrada}</Text>
                        <Text style={{ width: "12.5%", maxLines: 1 }}>{item.dataSaida}</Text>
                        <Text style={{ width: "8%", maxLines: 1 }}>{item.placa}</Text>
                        <Text style={{ width: "10%", maxLines: 1 }}>{item.carro}</Text>
                        <Text style={{ width: "10%", maxLines: 1 }}>{item.cor}</Text>
                        <Text style={{ width: "21%", maxLines: 1 }}>{item.cliente}</Text>
                        <Text style={{ width: "16%", maxLines: 1 }}>{item.tempo}</Text>
                        <Text style={{ width: "10%", maxLines: 1, textAlign: "right" }}>{item.valor.toLocaleString("pt-BR", { minimumFractionDigits: 2, maximumFractionDigits: 2 })}</Text>
                    </View>
                ))}

                {/* Totalizador */}
                <View style={{ flexDirection: "row", justifyContent: "flex-end", marginTop: 1, fontFamily: "Helvetica-Bold", fontSize: 8, textAlign: "right" }}>
                    <Text style={{ width: "90%" }}>Total R$:</Text>
                    <Text style={{ width: "10%" }}>{calcularTotal(dados)}</Text>
                </View>
            </Page>
        </Document>
    );
}
