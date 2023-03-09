import { IProduct } from "./product";

export interface ICategory {
  id: number;
  name: string;
  products: IProduct[]
  parentCategory: ICategory | null;
  subCategories: ICategory[];
}
