## Movies API

Movies API is designed and developed using spring boot supported by MySQL. Application build and dependency management are handled using maven.


## APIs

Movies app expose 3 different APIs

 1. Search Movies
 URL: /v1/movie
 2. Rate movie
 URL: /v1/rating
 3. Get top trending movies
 URL: /v1/trending

## Solution

The solution contains 3 APIs and is made to deal with the movie data. The application keeps the data of all movies in a table along with the Oscar victory status and theatre gross. 

Upon any request of a movie search, the solution will refer to the database and if data is present, OMDB API is invoked for further details. Once the response is received from the OMDB API, the data regarding theatre gross and poster will be saved to our table. This approach is adopted since we have to use these values while retrieving the top 10 movies.

Rating is made on a scale of 1 to 5. The application will save the total response count and average rating and update the same as and when new ratings are made.

While listing the top 10 movies the theatre gross(data from OMDB API) and an average rating is taken into consideration for sorting.
