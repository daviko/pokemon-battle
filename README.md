# Pokemon Battle API

This project simulates a battle between a human player and a computer player using Pokemon cards obtained from [Pokémon TCG API](https://docs.pokemontcg.io/). The battle involves randomly selecting cards for each player, executing the battle logic, and storing the battle results and the winner in a local database.

## Features

- REST API to manage Pokémon battles and battle results.
- CRUD operations for battle results.
- Endpoint to start a new Pokémon battle.

## Technologies Used

- **Spring Boot**: Framework to build the REST API.
- **Java 17**: The latest LTS version of Java.
- **Maven**: Dependency management and build tool.
- **JUnit 5 - JUnit Jupiter API**: Framework to create unit tests.
- **H2**: In-memory SQL database for storing battle results.
- **Docker**: Containerization of the application for easy deployment.
- **[Fly.io](https://fly.io)**: Developer-focused public cloud.

### Base URL

https://pokemon-battle.fly.dev/api/v1/pokemon

## Endpoints

### 1. Health Check
GET: https://pokemon-battle.fly.dev/api/v1/pokemon/health-check

### 2. Get All Battle Results
GET: https://pokemon-battle.fly.dev/api/v1/pokemon/battles/results

### 3. Get Battle Result By ID
GET: https://pokemon-battle.fly.dev/api/v1/pokemon/battles/results/{id}

### 4. Add a New Battle Result
POST: https://pokemon-battle.fly.dev/api/v1/pokemon/battles/results

Request body:
{
    "player1": {
        "id": 1,
        "name": "Ash Ketchum"
    },
    "player2": {
        "id": 2,
        "name": "Gary Oak"
    },
    "pokemonPlayer1": {
        "id": "mcd19-2",
        "name": "Alolan Exeggutor",
        "hp": 160,
        "attack": {
            "id": 9,
            "name": "Tropical Shake",
            "text": "This attack does 20 more damage for each type of basic Energy card in your discard pile. You can't add more than 100 damage in this way.",
            "damage": 20
        }
    },
    "pokemonPlayer2": {
        "id": "xy5-2",
        "name": "Kakuna",
        "hp": 80,
        "attack": {
            "id": 10,
            "name": "Bug Bite",
            "text": "",
            "damage": 20
        }
    },
    "finalHpPokemon1": 0,
    "finalHpPokemon2": 90,
    "winner": {
        "id": 2,
        "name": "Gary Oak"
    }
}

### 5. Update a Battle Result
PUT: https://pokemon-battle.fly.dev/api/v1/pokemon/battles/results/{id}

Request body:
{
    "id": 5,
    "player1": {
        "id": 1,
        "name": "Ash Ketchum"
    },
    "player2": {
        "id": 2,
        "name": "Gary Oak"
    },
    "pokemonPlayer1": {
        "id": "mcd19-2",
        "name": "Alolan Exeggutor",
        "hp": 160,
        "attack": {
            "id": 9,
            "name": "Tropical Shake",
            "text": "This attack does 20 more damage for each type of basic Energy card in your discard pile. You can't add more than 100 damage in this way.",
            "damage": 20
        }
    },
    "pokemonPlayer2": {
        "id": "xy5-2",
        "name": "Kakuna",
        "hp": 80,
        "attack": {
            "id": 10,
            "name": "Bug Bite",
            "text": "",
            "damage": 20
        }
    },
    "finalHpPokemon1": 0,
    "finalHpPokemon2": 90,
    "winner": {
        "id": 2,
        "name": "Gary Oak"
    }
}

### 6. Delete a Battle Result By ID
DELETE: https://pokemon-battle.fly.dev/api/v1/pokemon/battles/results/{id}

### 7. Start a New Battle
POST: https://pokemon-battle.fly.dev/api/v1/pokemon/battles/start-battle

Request body:
{
    "player1": {
        "id": 3,
        "name": "Misty"
    },
    "player2": {
        "id": 4,
        "name": "James"
    }
}

## Running the Application in localhost

1. Clone the Repository:
git clone https://github.com/daviko/pokemon-battle.git
cd pokemon-battle

2. Build the Application:
mvn clean package -DskipTests

3. Run the Application:
java -jar target/pokemon-battle-0.0.1-SNAPSHOT.jar

4. Run with Docker:

- Build the Docker image:
docker build -t pokemon-battle .

- Run the Docker container:
docker run -p 8080:8080 pokemon-battle

## Accessing the API

Once the application is running, you can access the API at http://localhost:8080/api/v1/pokemon/battles/results.

### Contribution
Feel free to fork this repository, open issues, or submit pull requests if you would like to contribute to the project.

## Author
- [David Leonardo Agudelo Villa](https://github.com/daviko)
