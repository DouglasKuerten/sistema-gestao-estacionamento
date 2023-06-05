import React from 'react';
import { Page, Text, View, Document, StyleSheet } from '@react-pdf/renderer';

const styles = StyleSheet.create({
    page: {
        height: `100%`,
        width: `100%`,
        flexDirection: 'row',
        padding: 30,
        backgroundColor: "#ffffff"

    },
    print: {
        flexDirection: 'row',
        height: `100%`,
        width: `100%`,
    },
    section: {
        margin: 10,
        padding: 10,
        flexGrow: 1
    }
});
export default function DayParking() {
    return (
        <Document title="Relatório de Exemplo">
            <Page size="A4" style={styles.page}>
                <View style={styles.print}>
                    <Text>Teste</Text>
                </View>
            </Page>
        </Document>
    )
}