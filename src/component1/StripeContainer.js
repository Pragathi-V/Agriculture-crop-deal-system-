import React from 'react'

import {Elements} from "@stripe/react-stripe-js"
import {loadStripe} from '@stripe/stripe-js'
import PaymentForm from './PaymentForm'
const PUBLIC_KEY = "pk_test_51LsKMKSDHw3BUdxnCP2t7fiMyB3X0fcXAgR7eJo3drScaHB1dWEEwuxYoO9OdpnmJIzc0sL9dig75Y2y7ki8q2q8000f3eWL5q"
const stripeTestPromise = loadStripe(PUBLIC_KEY)
export default function StripeContainer() {
  return (
    <Elements stripe={stripeTestPromise}>
        <PaymentForm />
        </Elements>
  )
}
