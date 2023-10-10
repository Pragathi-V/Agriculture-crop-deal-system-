import React from 'react'

const Login = () => {
  return (
    <>
      <section className='showcase login'>
        <div className='showcase-overlay'>
          <form className='form-control'>
            <input
              type='Enter Username'
              name='Enter Username'
              id='Enter Username'
              placeholder='Enter Username'
              required
            />
            <input type='password' name='password' id='password' placeholder='Enter Password'  required />
            <button type='submit'>Log In</button>
          </form>
        </div>
      </section>
    </>
  )
}

export default Login
