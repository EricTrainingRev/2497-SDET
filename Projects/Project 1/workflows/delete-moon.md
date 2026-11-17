```mermaid
graph TD
    Home[Home Page] -->|moon deletion| MoonDelete[Select Moon to Delete]
    MoonDelete -->|Confirm deletion| DeleteAction[Delete Moon from Database]
    DeleteAction -->|Success| TableRefresh[(Table Refresh)]
    TableRefresh --> Home
    DeleteAction -->|Failure| DeleteAlert((Browser Alert: Invalid moon selection))
```