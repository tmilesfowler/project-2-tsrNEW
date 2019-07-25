import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/common/home/home.component';
import { RegisterComponent } from './components/common/register/register.component';
import { LoginComponent } from './components/common/login/login.component';
import { CarEditComponent } from './components/common/car-edit/car-edit.component';


const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'signup', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'edit', component: CarEditComponent },
  { path: '**', redirectTo: '' }
 

];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
