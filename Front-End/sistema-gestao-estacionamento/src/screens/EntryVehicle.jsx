import Input from "../components/Input"
import Button from "../components/Button"
import ButtonTransparent from "../components/ButtonTransparent"

export default function EntryVehicle() {
    return (
        <div className="duration-300">
            <div className="pb-8">
                <h1 className="text-2xl font-semibold">Registrar Entrada de Veículo</h1>
            </div>

            <form>
                <div className="space-y-12">
                    <div className="border-b border-gray-900/10 pb-12">
                        <div className=" grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Placa" placeholder="" />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Modelo" placeholder="" />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Cor" placeholder="" />
                            <Input type="datetime-local" name="cliente" id="cliente" autoComplete="off" label="Data/Hora Entrada" placeholder="" />
                            <Input type="text" name="cliente" id="cliente" autoComplete="off" label="Cliente" placeholder="" />

                        </div>
                    </div>
                </div>

                <div className="mt-6 flex items-center justify-end gap-x-6">
                    <ButtonTransparent type="button">Cancelar</ButtonTransparent>
                    <Button type="submit" >Salvar</Button>
                </div>
            </form>
        </div>
    )
}
