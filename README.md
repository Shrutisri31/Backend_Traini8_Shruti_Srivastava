# Traini8 Training Center Registry

## Description
This project provides APIs to manage a registry of Government funded Training Centers.

## Setup Instructions
1. Clone the repository
2. Navigate to the project directory
3. Run mvn clean install
4. Start the application using mvn spring-boot:run
5. Access H2 Console at /h2-console with the credentials in application.properties

## API Endpoints
1. *Create Training Center*
   - Endpoint: POST /api/training-centers
   - Body: 
     json
     {
       "centerName": "Tech Center",
       "centerCode": "ABC123456789",
       "address": {
         "detailedAddress": "123 Tech Street",
         "city": "TechCity",
         "state": "TS",
         "pincode": "123456"
       },
       "studentCapacity": 100,
       "coursesOffered": ["Java", "Spring Boot"],
       "contactEmail": "contact@techcenter.com",
       "contactPhone": "1234567890"
     }
     

2. *Get All Training Centers*
   - Endpoint: GET /api/training-centers

## Validation
- CenterName: (Mandatory)less than 40 characters
- CenterCode: (Mandatory)exactly 12 characters
- Address: (Mandatory)detailed address, city, state, pincode
- Email: valid email format
- Phone: (Mandatory)10 digits

## Exception Handling
- Validation errors return a detailed message with the invalid fields.

