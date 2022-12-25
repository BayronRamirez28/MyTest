import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddCategoriaComponent } from './pages/admin/add-categoria/add-categoria.component';
import { AddLoteComponent } from './pages/admin/add-lote/add-lote.component';
import { AddProductoComponent } from './pages/admin/add-producto/add-producto.component';
import { AddProveedorComponent } from './pages/admin/add-proveedor/add-proveedor.component';
import { DashboardComponent } from './pages/admin/dashboard/dashboard.component';
import { UpdateCategoriaComponent } from './pages/admin/update-categoria/update-categoria.component';
import { UpdateProductoComponent } from './pages/admin/update-producto/update-producto.component';
import { UpdateProveedorComponent } from './pages/admin/update-proveedor/update-proveedor.component';
import { ViewCategoriasComponent } from './pages/admin/view-categorias/view-categorias.component';
import { ViewLotesComponent } from './pages/admin/view-lotes/view-lotes.component';
import { ViewProductosComponent } from './pages/admin/view-productos/view-productos.component';
import { ViewProveedoresComponent } from './pages/admin/view-proveedores/view-proveedores.component';
import { WelcomeComponent } from './pages/admin/welcome/welcome.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { SignupComponent } from './pages/signup/signup.component';
import { UserDashboardComponent } from './pages/user/user-dashboard/user-dashboard.component';
import { AdminGuard } from './services/admin.guard';
import { VendedorGuard } from './services/vendedor.guard';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'signup',
    component: SignupComponent,
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent,
    pathMatch: 'full'
  },
  {
    path: 'admin',
    component: DashboardComponent,
    canActivate: [AdminGuard],
    children: [
      {
      path: 'profile',
      component: ProfileComponent
    },
    {
      path: '',
      component: WelcomeComponent
    },
    {
      path: 'productos',
      component: ViewProductosComponent
    },
    {
      path: 'add-producto',
      component: AddProductoComponent
    },
    {
      path: 'update-producto/:id',
      component: UpdateProductoComponent
    },
    {
      path: 'categorias',
      component: ViewCategoriasComponent
    },
    {
      path: 'add-categoria',
      component: AddCategoriaComponent
    },
    {
      path: 'update-categoria/:id',
      component: UpdateCategoriaComponent
    },
    {
      path: 'proveedores',
      component: ViewProveedoresComponent
    },
    {
      path: 'add-proveedor',
      component: AddProveedorComponent
    },
    {
      path: 'update-proveedor/:id',
      component: UpdateProveedorComponent
    },
    {
      path: 'lotes',
      component: ViewLotesComponent
    },
    {
      path: 'add-lote',
      component: AddLoteComponent
    }
  ]
  },
  {
    path: 'user-dashboard',
    component: UserDashboardComponent,
    pathMatch: 'full',
    canActivate: [VendedorGuard]
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
