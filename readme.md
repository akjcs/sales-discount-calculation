
# sales-discount-calculation 

As a big telecom brand outlet, on the eve of Christmas, we want to offer attractive seasonal discounts to our
customers to boost our retail sales for our sim card outlets partners.


## Requirements (required)

Design the solution that calculate customer billing after applying the different user discount slab


## solution 

Designed the application on solid principle that defined class for catering the different type of user like Regular and Billing,In future new user like Gold or silver user functionality can be extended by extending the base functional interface

Code coverage is close to 95%

## How to run application

* API end point POST(http://localhost:8080/bill-calculation)
*  Request Payload
    {
    "customer-type":"premium",
    "purchase-amount":4000
    }
 * Response payload 
  {
    "bill-amount": "3600"
  }
  or
  {
    "customer-type":"pppp",
    "purchase-amount":4000
    }
  {
    "errorMessage": "Please enter a valid customer type"
 }

Also test through junit test class


these two class covered all the use cases written into the problem statement



