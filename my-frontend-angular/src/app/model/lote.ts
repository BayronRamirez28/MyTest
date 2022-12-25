import { Producto } from "./producto";
export class Lote {
    id!: number;
    quantity!: number;
    price_shopping!: number;
    registration_date!: Date;
    expiration_date!: Date;
    product!: Producto;
}