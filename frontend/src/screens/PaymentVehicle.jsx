import Input from "../components/Input"
import Button from "../components/Button"
import ButtonTransparent from "../components/ButtonTransparent"

export default function PaymentVehicle({ values }) {
    return (
        <div className="flex duration-300 flex-col">
            <div className="pb-8">
                <h1 className="text-2xl font-semibold">Resumo do Período Estacionado</h1>
            </div>

            <form>
                <div className="space-y-8">
                    <div className="border-b border-gray-900/10 pb-8">
                        <h2 className="text-base font-semibold leading-7 text-gray-900">Informações do Veículo</h2>
                        <p className="mt-1 text-sm leading-6 text-gray-600 ">
                            Modelo/Cor/Placa/Cliente
                        </p>
                    </div>
                    <div className="border-b border-gray-900/10 pb-8">
                        <h2 className="text-base font-semibold leading-7 text-gray-900">Horas Estacionado</h2>
                        <p className="mt-1 text-sm leading-6 text-gray-600 ">
                            Data Entrada - Data Saída
                        </p>
                        <div className="py-3">
                            <h4 className="text-sm font-semibold leading-7 text-gray-900">Entrada</h4>
                            <p className="mt-1 text-sm leading-6 text-gray-600">
                                Data Entrada
                            </p>
                            <h4 className="text-sm font-semibold leading-7 text-gray-900">Saída</h4>
                            <p className="mt-1 text-sm leading-6 text-gray-600">
                                Data Saída
                            </p>
                        </div>
                    </div>
                    <div className="border-b border-gray-900/10 pb-8">
                        <h2 className="text-base font-semibold leading-7 text-gray-900">Valor</h2>
                        <p className="mt-1 text-sm leading-6 text-gray-600 ">
                            Valor a ser pago
                        </p>
                    </div>
                </div>

                {/*                 <div className="mt-6 flex items-center justify-end gap-x-6">
                    <ButtonTransparent type="button">Cancelar</ButtonTransparent>
                    <Button type="submit" >Finalizar</Button>
                </div> */}
            </form>
        </div>
    )
}
