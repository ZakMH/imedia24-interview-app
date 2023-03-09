import { useQuery } from "@tanstack/react-query";
import { client } from "../helpers/client";
import { ICategory } from "../interfaces/category";

const getCategories = () => client.get<ICategory[]>("/categories/");

export const useGetCategories = () =>
  useQuery({
    queryKey: ["categories"],
    queryFn: getCategories,
  });
