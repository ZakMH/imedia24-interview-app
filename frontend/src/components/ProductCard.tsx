import { Link, useParams } from "react-router-dom";
import { IProduct } from "../interfaces/product";

interface ProductCardProps extends IProduct {}

export function ProductCard({ id, image, name, price }: ProductCardProps) {
  const params = useParams();
  
  return (
    <Link to={`/${params.categoryId}/${id}`}>
      <div className="w-4/5 flex flex-col gap-2 bg-white p-2 pb-3 rounded-md hover:bg-slate-50">
        <figure className="rounded-md overflow-hidden">
          <img className="w-full h-40 object-cover" src={image} alt={name} />
        </figure>
        <div className="space-y-2">
          <p className="bg-slate-800 text-white w-fit p-1 rounded-md text-sm font-medium">
            {price}
            <span className="">€</span>
          </p>
          <p className="font-medium">{name}</p>
        </div>
      </div>
    </Link>
  );
}
