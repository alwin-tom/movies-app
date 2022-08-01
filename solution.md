## Movies API

Movies API is designed and developed using spring boot supported by MySQL. Application build and dependency management are handled using maven.

## APIs

Movies app expose 3 different APIs

1. Search Movies

URL: /v1/movie
Method: GET
Param: movieName

2. Rate movie

URL: /v1/rating
Method: POST
Params: rating, movieId and imdbId

3. Get top trending movies

URL: /v1/trending
Method: GET

 ## API Token
 All the APIs exposed through this application is expected to receive an API token with key name **client-token**. As a part of the current solution, the validation of the token is only considered towards the existance of the same in the request header. The value of client secret can be a String value and needs to be passed as a part of the header. 

## Solution approach


The solution contains 3 APIs and is made to deal with the movie data. The application keeps the data of all movies in a table along with the Oscar victory status and theatre gross.

1. Upon any request for a movie search, the solution will refer to the database with values that were shared in CSV. If data is present, OMDB API is invoked for further details. Once the response is received from the OMDB API, the data regarding theatre gross and poster will be saved to our table. This approach is adopted since we have to use these values while retrieving the top 10 movies.

2. If the values are not present in the movie list provided in the CSV file, a response body with parameter **isMoviePresent** and value **false** will be returned and vice versa. Once the movie name is confirmed against the values mentioned in the CSV, the same movie name will be used as the search parameter for OMDB Movie API.

Movie Search API responds with a response as depicted below

~~~
{

	"$schema": "http://json-schema.org/draft-04/schema#",
	"type": "object",
	"properties": {
		"isMoviePresent": {
			"type": "boolean"
		},
		"movieDetails": {
			"type": "object",
			"properties": {
				"movieId": {
					"type": "integer"
				},
				"movieName": {
					"type": "string"
				},
				"hasWonOscar": {
					"type": "boolean"
				},
				"theatreGross": {
					"type": "integer"
				},
				"averageRating": {
					"type": "integer"
				},
				"imdbId": {
					"type": "string"
				},

				"totalRatings": {
					"type": "integer"
				},
				"poster": {
					"type": "string"
				}
			},
			"required": [
				"movieId",
				"movieName",
				"hasWonOscar",
				"theatreGross",
				"averageRating",
				"imdbId",
				"totalRatings",
				"poster"
			]
		},
		"movieDetailsResponse": {
			"type": "object",
			"properties": {
				"Title": {
					"type": "string"
				},
				"Year": {
					"type": "string"
				},
				"Rated": {
					"type": "string"
				},
				"Released": {
					"type": "string"
				},
				"Runtime": {
					"type": "string"
				},
				"Genre": {
					"type": "string"
				},
				"Director": {
					"type": "string"
				},
				"Writer": {
					"type": "string"
				},
				"Actors": {
					"type": "string"
				},
				"Plot": {
					"type": "string"
				},
				"Language": {
					"type": "string"
				},
				"Country": {
					"type": "string"
				},
				"Awards": {
					"type": "string"
				},
				"Poster": {
					"type": "string"
				},
				"Metascore": {
					"type": "string"
				},
				"imdbRating": {
					"type": "string"
				},
				"imdbVotes": {
					"type": "string"
				},
				"imdbID": {
					"type": "string"
				},
				"Type": {
					"type": "string"
				},
				"DVD": {
					"type": "string"
				},
				"BoxOffice": {
					"type": "string"
				},
				"Production": {
					"type": "string"
				},
				"Website": {
					"type": "string"
				},
				"Response": {
					"type": "string"
				},
				"Ratings": {
					"type": "array",
					"items": [{
						"type": "object",
						"properties": {
							"Source": {
								"type": "string"
							},
							"Value": {
								"type": "string"
							}
						},
						"required": [
							"Source",
							"Value"
						]
					}]
				}
			},
			"required": [
				"Title",
				"Year",
				"Rated",
				"Released",
				"Runtime",
				"Genre",
				"Director",
				"Writer",
				"Actors",
				"Plot",
				"Language",
				"Country",
				"Awards",
				"Poster",
				"Metascore",
				"imdbRating",
				"imdbVotes",
				"imdbID",
				"Type",
				"DVD",
				"BoxOffice",
				"Production",
				"Website",
				"Response",
				"Ratings"
			]
		}
	},
	"required": [
		"isMoviePresent",
		"movieDetails",
		"movieDetailsResponse"
	]
}
~~~

  

  

3. Rating is made on a scale of 1 to 5. The application will save the total response count and average rating and update the same as and when new ratings are made. Once the rating is successfully made, the API will respond with a data in the following JSON schema.

~~~

{
"$schema": "http://json-schema.org/draft-04/schema#",
"type": "object",
"properties": {
"movieId": {
"type": "integer"
},
"movieName": {
"type": "string"
},
"hasWonOscar": {
"type": "boolean"
},
"theatreGross": {
"type": "integer"
},
"averageRating": {
"type": "number"
},
"imdbId": {
"type": "string"
},
"totalRatings": {
"type": "integer"
},
"poster": {
"type": "string"
}
},
"required": [
"movieId",
"movieName",
"hasWonOscar",
"theatreGross",
"averageRating",
"imdbId",
"totalRatings",
"poster"
]
}

~~~

4. While listing the top 10 movies the theatre gross(data from OMDB API) and an average rating are taken into consideration for sorting. Response message schema of the request is as follows

~~~

{
	"$schema": "http://json-schema.org/draft-04/schema#",
	"type": "array",
	"items": [{
		"type": "object",
		"properties": {
			"movieId": {
				"type": "integer"
			},
			"movieName": {
				"type": "string"
			},
			"hasWonOscar": {
				"type": "boolean"
			},
			"theatreGross": {
				"type": "integer"
			},
			"averageRating": {
				"type": "number"
			},
			"imdbId": {
				"type": "string"
			},
			"totalRatings": {
				"type": "integer"
			},
			"poster": {
				"type": "string"
			}
		},
		"required": [
			"movieId",
			"movieName",
			"hasWonOscar",
			"theatreGross",
			"averageRating",
			"imdbId",
			"totalRatings",
			"poster"
		]
	}]
}

~~~

**Note: More insights regarding the request payload and response messages can be obtained using the swagger UI**