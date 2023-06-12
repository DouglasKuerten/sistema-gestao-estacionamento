
import { BsCheckCircle, BsXCircle, BsQuestionCircle } from "react-icons/bs"

export default function Alert(props) {
    var icon = <BsQuestionCircle color={'#000000'} />;
    if (props.type === 'sucess') {
        icon = <BsCheckCircle color="#44C997" size={'20'} />;
    } else if (props.type === 'error') {
        icon = <BsXCircle color="#c94447" size={'20'} />;
    } else if (props.type === 'attention') {
        icon = <BsInfoCircle color="#c9a044" size={'20'} />;
    }

    return (
        <div className="absolute right-2 z-50">
            <div className="m-auto">
                <div className="bg-white rounded-lg border-gray-300 border p-3 shadow-lg">
                    <div className="flex flex-row">
                        <div className="px-2 pt-1">
                            {icon}
                        </div>
                        <div className="ml-2 mr-6">
                            <span className="font-semibold">{props.title}</span>
                            <span className="block text-gray-500">{props.text}</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>)
}