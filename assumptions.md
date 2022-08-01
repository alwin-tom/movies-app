### Assumptions
The application is developed under the following assumptions

 1. All movie details are stored in the database under the table **movie_details**. Details may include 
 a. movie_name
 b. has_won_oscar
 2. movie_name is based on the values provided in the CSV and it is assumed that the name in the CSV and OMDB API is matching.
 3. has_won_oscar is a boolean value and should be saved as 0 or 1 in database, 0 being false and 1 being true.
