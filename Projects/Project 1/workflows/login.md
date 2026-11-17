```mermaid
graph TD
    Start((Start)) --> LoginPage[Login Page]
    LoginPage -->|Enter credentials| AuthCheck{Valid credentials?}
    AuthCheck -->|Invalid| LoginFail((Browser Alert: Invalid Credentials))
    AuthCheck -->|Valid| HomePage[Home Page]
    HomePage -->|Logout| LoginPage
```