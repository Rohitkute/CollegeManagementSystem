import React, { useState } from "react"
export default function(props)
{
    return (
        <div className="Auth-form-container">
          <form className="Auth-form">
            <div className="Auth-form-content">
              <h3 className="Auth-form-title">Student Registration</h3>
              
              <tr className="form-group mt-3">
                <td>First Name</td>
                <input
                  type="text"
                  className="form-control mt-1"
                  placeholder="Enter Your First Name"
                />
              </tr>

              <tr className="form-group mt-3">
                <td>Email</td>
                <input
                  type="email"
                  className="form-control mt-1"
                  placeholder="Enter Your Last Name"
                />
              </tr>

              <tr className="form-group mt-3">
                <td>Username</td>
                <input
                  type="text"
                  className="form-control mt-1"
                  placeholder="Enter Your Username Name"
                />
              </tr>

              <tr className="form-group mt-3">
                <td>Password</td>
                <input
                  type="password"
                  className="form-control mt-1"
                  placeholder="Enter Your Username Name"
                />
              </tr>

              <tr className="form-group mt-3">
                <td>Address</td>
                <input
                  type="number"
                  className="form-control mt-1"
                  placeholder="Enter Your Username Name"
                />
              </tr>


              <tr className="form-group mt-3">
                <td>Contact</td>
                <input
                  type="text"
                  className="form-control mt-1"
                  placeholder="Email Address"
                />
              </tr>

              {/* <tr className="form-group mt-3">
                <td>City</td>
                <input
                  type="text"
                  className="form-control mt-1"
                  placeholder="Enter City"
                />
              </tr>

              <tr className="form-group mt-3">
                <td>Pincode</td>
                <input
                  type="number"
                  className="form-control mt-1"
                  placeholder="Enter Pin Code"
                />
              </tr>

              <tr className="form-group mt-3">
                <td>Password</td>
                <input
                  type="password"
                  className="form-control mt-1"
                  placeholder="Password"
                />
              </tr> */}

              <div className="d-grid gap-2 mt-3">
                <button type="submit" className="btn btn-primary">
                  Submit
                </button>
              </div>

              <p className="text-center mt-2">
                Forgot <a href="#">password?</a>
              </p>
            </div>
          </form>
        </div>
      )
    }