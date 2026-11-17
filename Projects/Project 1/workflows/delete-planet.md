```mermaid
graph TD
    Home[Home Page] -->|planet deletion| DeleteForm[Select Planet to Delete]
    DeleteForm -->|Confirm deletion| DeleteAction[Delete Planet from Database]
    DeleteAction -->|Success| CascadeMoons[Cascade delete associated moons]
    CascadeMoons --> TableRefresh[(Table Refresh)]
    TableRefresh --> Home
    DeleteAction -->|Failure| DeleteAlert((Browser Alert: Invalid planet selection))
```