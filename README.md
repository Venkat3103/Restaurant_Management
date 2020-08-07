# Restaurant-Management
# Case Study on Restaurant Management using JAVA.

## Classes of the Case Study

| **Object** | **State** | **Behavior** |
| --- | --- | --- |
| **Waiter** | TableNo<br/>ItemNo<br/>Item Name<br/>Quantity<br/>Availability<br/>Order Status<br/>Feedback | SearchItem() <br/> ConfirmOrder() <br/> SetOrderStatus() <br/> AddToBill() <br/> GetFeedback() |
| **Customer** | Reservation ID<br/>Name<br/>TableNo<br/>NumberOfGuests<br/>OrderItems<br/>Bill | SearchItem() <br/> OrderItem() <br/> PlaceBill() |
| **Menu** | Cuisine<br/>Type<br/>Name<br/>Recipe<br/>Price | GetAvailability()|
| **Kitchen** | ResourceType<br/>ResourceLevel<br/>Availavility<br/>CurrentStatus | SetAvailability() <br/> SetCurrentStatus()|
| **Restaurant** | Status<br/>Table No<br/>BillAmount<br/>Overall Feedback | SetStatus() <br/> CalcBill() <br/> SendBill() <br/> SetFeedback() |
| **Table** | TableNo<br/>NoOfSeats<br/>Status | SetStatus() <br/> AssignTable() <br/> ChangeNOS() |
| **Reservation** | ReservationID<br/>NoOfGuests<br/>Name | Read() |
| **Feedback** | Name<br/>Feedback<br/>Email-ID<br/>Birth Anniversary<br/>Phone Number | Read() <br/> UploadFeedback() |

#
## Object Interaction

| **Object Names** | **Purpose** |
| --- | --- |
| Customer, Waiter | Table booking, Table allocation, Order placement, Receiving bills and payment |
| Waiter, Kitchen | Passing orders, Checking availability of dishes, return of order and its current status |
| Waiter, Restaurant | Checking table availability status, Passing oforders, Preparing bills. |

#
## OBJECT MODEL

![Object Model](images/objectModel.png)
