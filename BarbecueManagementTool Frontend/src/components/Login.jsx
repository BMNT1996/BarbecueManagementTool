import React, { Component } from 'react'
import { Store } from 'react-notifications-component';
import { jwtDecode } from 'jwt-decode';
import axios from 'axios'
import Cookies from 'js-cookie';
import Icon from "../assets/icon.png"

import 'bootstrap/dist/css/bootstrap.min.css';

import "./Login.css"

const URLLogin = 'http://localhost:4000/auth/login'
const URLRegister = 'http://localhost:4000/auth/register'

export default class Login extends Component {

  constructor(props) {
    super(props)
    this.state = {
      isLogin: true,
      user: {
        name: "Rafael",
        email: "",
        password: "12345",
        passwordConfirmation: ""
      }
    }

    this.switchMode = this.switchMode.bind(this)
    this.handleLogin = this.handleLogin.bind(this)
    this.handleUser = this.handleUser.bind(this)
  }

  switchMode = () => {
    this.setState({ ... this.state, isLogin: !this.state.isLogin })
  };

  handleLogin = () => {
    if (this.state.isLogin) {
      const body = JSON.stringify({
        username: this.state.user.name,
        password: this.state.user.password
      })
      console.log(body)
      axios.post(URLLogin, body, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(resp => {
          const token = resp.data.jwt;
          if (token != null && token != "") {
            Cookies.set('token', token, { expires: 7, secure: true })
            console.log(jwtDecode(token).sub)
            window.location.reload();
          } else {
            Store.addNotification({
              title: "Login Failed!",
              message: "Your username or password is incorrect",
              type: "danger",
              insert: "top",
              container: "top-right",
              animationIn: ["animate__animated", "animate__fadeIn"],
              animationOut: ["animate__animated", "animate__fadeOut"],
              dismiss: {
                duration: 2000,
                onScreen: true
              }
            });
          }

        }
        )
    } else {
      if (this.state.user.password !== this.state.user.passwordConfirmation) {
        console.log("Password don't match")
        return false
      }
      const body = JSON.stringify({
        username: this.state.user.name,
        password: this.state.user.password
      })
      console.log(body)
      axios.post(URLRegister, body, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
        .then(resp => {
          console.log(resp)
          window.location.reload();
        })
    }
  }

  handleUser(e) {
    console.log(e.target.id)
    switch (e.target.id) {
      case "name":
        this.setState({ ...this.state, user: { ...this.state.user, name: e.target.value } });
        break
      case "email":
        this.setState({ ...this.state, user: { ...this.state.user, email: e.target.value } });
        break
      case "password":
        this.setState({ ...this.state, user: { ...this.state.user, password: e.target.value } });
        break
      case "passwordConfirm":
        this.setState({ ...this.state, user: { ...this.state.user, passwordConfirmation: e.target.value } });
        break
    }
    console.log(this.state.user)
  }
  render() {
    return (
      <div className="d-flex h-100 align-items-center py-4 bg-body-tertiary">
        <main className="form-signin w-100 m-auto">
          <form onSubmit={this.handleLogin}>
            <img className="mb-4" src={Icon} alt="" width="72" height="57" />
            <h1 className="h3 mb-3 fw-normal">{this.state.isLogin ? "Please sign in" : "Please sign up"}</h1>
            <div className="form-floating my-3">
              <input type="email" className="form-control" id="name" placeholder="name" value={this.state.user.name} onChange={this.handleUser} />
              <label htmlFor="name">Name</label>
            </div>
            {!this.state.isLogin && <div className="form-floating my-3">
              <input type="email" className="form-control" id="email" placeholder="name@example.com" value={this.state.user.email} onChange={this.handleUser} />
              <label htmlFor="mail">Email address</label>
            </div>}
            <div className="form-floating my-3">
              <input type="password" className="form-control" id="password" placeholder="Password" value={this.state.user.password} onChange={this.handleUser} />
              <label htmlFor="password">Password</label>
            </div>
            {!this.state.isLogin && <div className="form-floating my-3">
              <input type="password" className="form-control" id="passwordConfirm" placeholder="Password" value={this.state.user.passwordConfirmation} onChange={this.handleUser} />
              <label htmlFor="passwordConfirm">Password Confirm</label>
            </div>}
            <div className="form-check text-start my-3">
              <input className="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault" />
              <label className="form-check-label" htmlFor="flexCheckDefault">
                Remember me
              </label>
            </div>
            <button className="btn btn-primary w-100 py-2" type="submit" onClick={this.handleLogin}>Sign in</button>
            <div className="d-flex flex-row-reverse">
              <a className="switchText" onClick={this.switchMode}>{this.state.isLogin ? "Register" : "Login"}</a>
            </div>
            <p className="subtitle">
              <a onClick={this.props.login} href="#" className="btn btn-lg btn-light fw-bold border-white bg-white">Login / Register</a>
            </p>
            <p className="mt-5 mb-3 text-body-secondary">&copy; 2023–{new Date().getFullYear()}</p>
          </form>
        </main>
      </div>
    )
  }
}