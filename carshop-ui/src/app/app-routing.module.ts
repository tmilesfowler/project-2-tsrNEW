import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/common/home/home.component';
import { RegisterComponent } from './components/common/register/register.component';
import { LoginComponent } from './components/common/login/login.component';
import { CarEditComponent } from './components/common/car-edit/car-edit.component';
import { CarCustomerComponent } from './components/common/car-customer/car-customer.component';
import { CustomerListComponent } from './components/common/customer-list/customer-list.component';
import { PasswordResetComponent } from './components/common/password-reset/password-reset.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'signup', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'edit', component: CarEditComponent },
  { path: 'viewcars', component: CarCustomerComponent },
  { path: 'customerlist', component: CustomerListComponent },
  { path: 'resetPassword', component: PasswordResetComponent },
  { path: '**', redirectTo: '' }
 

];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
