import { useQuery } from "@tanstack/react-query";
import { client } from "../helpers/client";
import { ICategory } from "../interfaces/category";
import { IProduct } from "../interfaces/product";

const getProducts = (categoryId: string) =>
  client.get<ICategory>(`/categories/${categoryId}`);

export const useGetProducts = (categoryId: string) =>
  useQuery({
    queryKey: ["products", categoryId],
    queryFn: () => getProducts(categoryId),
  });

const getProduct = (productId: string) =>
  client.get<IProduct>(`/products/${productId}`);

export const useGetProduct = (productId: string) =>
  useQuery({
    queryKey: ["product", productId],
    queryFn: () => getProduct(productId),
  });
