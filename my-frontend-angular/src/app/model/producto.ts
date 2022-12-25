import { Categoria } from "./categoria";
import { Proveedor } from "./proveedores";
export class  Producto{
    id!:number;
    name!: String;
    quantity!:number;
    sale_price!:number;
    estate!:String;
    detail!:String;
    minimun_quantity!:number;
    category!: Categoria;
    supplier!: Proveedor;

}