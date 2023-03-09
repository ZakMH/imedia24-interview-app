import { useParams } from "react-router-dom";
import { useGetProduct } from "../hooks/useGetProducts";

export function ProductPage() {
  const params = useParams();
  const { data } = useGetProduct(params.productId || "");

  return (
    <div className="space-y-6">
      <div className="border-b pb-4">
        <h1 className="text-lg font-medium">
          {data?.data.name}
        </h1>
      </div>
      <div className="grid grid-cols-5 gap-4">
        <div className="col-span-2">
          <figure className="rounded-md overflow-hidden">
            <img
              className="w-full object-cover"
              src={data?.data.image}
              alt={data?.data.name}
            />
          </figure>
        </div>
        <div className="col-span-3">
          <div className="space-y-2">
            <p className="bg-slate-600 text-white w-fit px-2 py-1 rounded-md font-medium">
              {data?.data.price}
              <span className="">€</span>
            </p>
            <p className="font-bold text-xl">{data?.data.name}</p>
            <hr />
            <p className="text-slate-500 leading-relaxed">
              Lorem ipsum dolor sit, amet consectetur adipisicing elit. Corporis,
              ipsa neque? Aliquam voluptate amet blanditiis ipsa sapiente odit
              assumenda fuga doloremque. Qui nam facilis sed rerum unde inventore
              error dolor.
            </p>
            <div className="flex gap-4">
              <button className="font-medium text-lg bg-slate-900 text-white px-4 py-2 rounded-md hover:bg-slate-700">
                Buy now
              </button>
              <button className="font-medium text-lg border-2 border-slate-900 text-slate-900 px-4 py-2 rounded-md hover:bg-slate-200">
                Add to cart
              </button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
