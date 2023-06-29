import React, { useState, useEffect } from 'react';
import { Page, Text, View, Document, Svg, Path } from '@react-pdf/renderer';
import { BsPinFill } from "react-icons/bs"
import axios from 'axios';
import moment from "moment";
import 'moment/locale/pt-br'
moment.locale('pt-br')

export default function RankVehiclesParked({ filterValues }) {
    const [databaseValues, setDatabaseValues] = useState([]);

    useEffect(() => {
        axios.get(import.meta.env.VITE_DB_URL + 'rankEstacionamento/' + filterValues.dataInicio + "/" + filterValues.dataFim)
            .then(response => {
                const data = response.data;
                setDatabaseValues(data);
                console.log(response)
            })
            .catch(error => {
                console.error(error);
            });
    }, []);


    return (
        <Document title='Ranking de Horas Estacionadas por Período'>
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
                        <Text style={{ fontSize: 16, fontFamily: "Helvetica-Bold", textAlign: "center" }}>Ranking de Horas Estacionadas</Text>
                        <Text style={{ fontSize: 9, fontFamily: "Helvetica", textAlign: "center" }}>{`Período de ${moment(filterValues.dataInicio).format("DD/MM/YYYY")} até ${moment(filterValues.dataFim).format("DD/MM/YYYY")}`}</Text>
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
                    <Text style={{ width: "5%", marginBottom: 5 }}>Rank</Text>
                    <Text style={{ width: "8%", marginBottom: 5 }}>Placa</Text>
                    <Text style={{ width: "20%", marginBottom: 5 }}>Modelo</Text>
                    <Text style={{ width: "35%", marginBottom: 5 }}>Cliente</Text>
                    <Text style={{ width: "20%", marginBottom: 5 }}>Tempo Decorrido Total</Text>
                    <Text style={{ width: "12%", marginBottom: 5, textAlign: "right" }}>Valor Total</Text>
                </View>

                {/* Dados */}
                {databaseValues.map((dado, index) => (
                    <View wrap={false} key={index} style={{ flexDirection: "row", marginBottom: 2, fontSize: 8, fontFamily: "Helvetica" }}>
                        <Text style={{ width: "5%", maxLines: 1 }}>{dado.RANK}</Text>
                        <Text style={{ width: "8%", maxLines: 1 }}>{dado.DS_PLACA}</Text>
                        <Text style={{ width: "20%", maxLines: 1 }}>{dado.DS_MODELO}</Text>
                        <Text style={{ width: "35%", maxLines: 1 }}>{dado.DS_NOME}</Text>
                        <Text style={{ width: "20%", maxLines: 1 }}>{dado.TEMPO_DECORRIDO_TOTAL}</Text>
                        <Text style={{ width: "12%", maxLines: 1, textAlign: "right" }}>{dado.VALOR.toLocaleString("pt-BR", { minimumFractionDigits: 2, maximumFractionDigits: 2 })}</Text>
                    </View>
                ))}
            </Page>
        </Document>
    );
}
