import { Link } from "react-router-dom";
import Button from "../components/Button";

export default function NotFound(props) {
    return (
        <div className="grid min-h-full place-items-center px-6 py-24 sm:py-32 lg:px-8">
            <div className="text-center">
                <h1 className="text-5xl font-semibold text-blue-600">404</h1>
                <h1 className="mt-4 text-3xl font-bold tracking-tight text-gray-900 sm:text-5xl">Página não encontrada</h1>
                <p className="mt-6 text-base leading-7 text-gray-600">Desculpe, não encontramos a página que você está procurando.</p>
                <div className="mt-10 flex items-center justify-center gap-x-6">
                    <Link to={"/"} className={`flex flex-row ${!open ? "justify-center" : "justify-start"} gap-x-3 items-center rounded-md bg-blue-600 px-3.5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-blue-500 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600`}>
                        Voltar a página inicial
                    </Link>

                </div>
            </div>
        </div>

    )
}


