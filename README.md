# 📍 Hiring Assignment: Processing Map Data with Metadata

## **🔹 Project Overview**
This Spring Boot application processes and analyzes **map data** from two JSON files:
- **Locations JSON**: Contains location IDs, latitude, and longitude.
- **Metadata JSON**: Contains additional metadata like type, rating, and reviews.

The goal is to **load, merge, and analyze** this data to extract insights like:
- Counting valid locations by type.
- Calculating average ratings.
- Identifying the location with the highest reviews.
- Detecting incomplete data entries.

---

## **📌 Features Implemented**
✅ **Load and parse JSON files.**  
✅ **Merge data based on `id`.**  
✅ **Count valid points per type (restaurant, hotel, etc.).**  
✅ **Calculate the average rating per type.**  
✅ **Identify the highest-reviewed location.**  
✅ **Detect incomplete data (locations missing metadata).**  

---

## **⚙️ Technology Stack**
- **Backend**: Java, Spring Boot  
- **JSON Processing**: Jackson  
- **Build Tool**: Maven  
- **Testing**: Postman  

---

## **🌐 API Endpoints**
| Method | Endpoint | Description | Screenshot |
|--------|----------|-------------|------------|
| **GET** | `/api/v1/mapdata/load` | Loads JSON data into the system. | ![Load Data](json_data_read_project/screenshot/Screenshot_1.png) |
| **GET** | `/api/v1/mapdata/merged` | Returns merged location and metadata. | ![Merged Data](json_data_read_project/screenshot/Screenshot_2.png) |
| **GET** | `/api/v1/mapdata/valid-count` | Counts valid locations per type. | ![Valid Count](json_data_read_project/screenshot/Screenshot_3.png) |
| **GET** | `/api/v1/mapdata/average-ratings` | Calculates average rating per type. | ![Average Ratings](json_data_read_project/screenshot/Screenshot_4.png) |
| **GET** | `/api/v1/mapdata/highest-reviews` | Identifies the location with the highest reviews. | ![Highest Reviews](json_data_read_project/screenshot/Screenshot_6.png) |
| **GET** | `/api/v1/mapdata/incomplete-data` | Lists locations missing metadata. | ![Incomplete Data](json_data_read_project/screenshot/Screenshot_5.png) |

---

## **🛠 Project Setup & Installation**
### **1️⃣ Clone the Repository**
```sh
git clone https://github.com/Richadxt/Processing-Map-Data-with-Metadata.git
cd Processing-Map-Data-with-Metadata
