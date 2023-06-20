import Input from "../components/Input"
import Button from "../components/Button"
import ButtonTransparent from "../components/ButtonTransparent"
import { Link } from "react-router-dom"

export default function ExitVehicle() {
    return (
        <div className="duration-300">
            <div className="pb-8">
                <h1 className="text-2xl font-semibold">Registrar Saída de Veículo</h1>
            </div>

            <form>
                <div className="space-y-12">
                    <div className="border-b border-gray-900/10 pb-12">
                        <div className=" grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Placa" placeholder="" required={true} />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Modelo" placeholder="" disabled />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Cor" placeholder="" disabled />
                            <Input type="datetime-local" name="cliente" id="cliente" autoComplete="off" label="Data/Hora Saída" placeholder="" required={true} />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Cliente" placeholder="" disabled />

                        </div>
                        <h2 className="text-base font-semibold leading-7 text-gray-900 pt-10">Atenção</h2>
                        <p className="mt-1 text-sm leading-6 text-gray-600">
                            Após encerrar o período você será redirecionado para a página de pagamento.
                        </p>
                    </div>
                </div>


                <div className="mt-6 flex items-center justify-end gap-x-6">
                    <ButtonTransparent type="button">Cancelar</ButtonTransparent>
                    <Button type="submit">
                        <Link to={"resumoPagamentoVeiculo"}>
                            Encerrar
                        </Link>
                    </Button>

                </div>
            </form>
        </div>
    )
}
