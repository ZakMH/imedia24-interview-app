import { useParams } from "react-router-dom";
import { ProductCard } from "../components/ProductCard";
import { useGetProducts } from "../hooks/useGetProducts";

export function ProductsPage() {
  const params = useParams();
  const { data } = useGetProducts(params.categoryId || "");

  return (
    <div className="space-y-6">
      <div className="border-b pb-4">
        <h1 className="text-lg font-medium">{data?.data?.name}</h1>
      </div>
      <div className="grid grid-cols-4 gap-y-4">
        {data?.data?.products.map((product) => (
          <ProductCard key={product.id} {...product} />
        ))}
      </div>
    </div>
  );
}
