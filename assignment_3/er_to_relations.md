# Transforming ER diagram into appropriate relations
## Entities
- Category
- Product
- Picture
- Customer
- Order
- Coupon
- Rating
## Attributes
### 1.Category
    - category_ID(PRIMARY KEY)
    - category_name
### 2.Product
    - product_ID(PRIMARY KEY)
    - product_name
    - price
    - quantity
    - category_ID(FOREIGN KEY)
### 3.Picture
    - pictureID(PRIMARY KEY)
    - pictureURL
    - product_ID(FOREIGN KEY)
### 4.Customer
    - customer_ID(PRIMARY KEY)
    - customer_name
    - phone_no
    - email
    - house_no
    - city
    - state
    - pincode
    - country
### 5.Order
    - order_ID(PRIMARY KEY)
    - order_date
    - order_details
    - total_amount
    - customer_ID(FOREIGN KEY)
### 6.Coupon
    - coupon_code(PRIMARY KEY)
    - discount
### 7.Rating
    - rating_ID(PRIMARY KEY)
    - date
    - rating
    - feedback
    - customer_ID(FOREIGN KEY)
    - product_ID(FOREIGN KEY)
