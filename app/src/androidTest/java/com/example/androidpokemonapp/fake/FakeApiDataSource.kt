package com.example.androidpokemonapp.fake

import com.example.androidpokemonapp.data.database.DbPokemonList
import com.example.androidpokemonapp.model.Pokemon
import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.network.responses.Ability
import com.example.androidpokemonapp.network.responses.AbilityX
import com.example.androidpokemonapp.network.responses.ApiPokemon
import com.example.androidpokemonapp.network.responses.ApiPokemonList
import com.example.androidpokemonapp.network.responses.Move
import com.example.androidpokemonapp.network.responses.MoveLearnMethod
import com.example.androidpokemonapp.network.responses.MoveX
import com.example.androidpokemonapp.network.responses.Result
import com.example.androidpokemonapp.network.responses.Type
import com.example.androidpokemonapp.network.responses.TypeX
import com.example.androidpokemonapp.network.responses.VersionGroup
import com.example.androidpokemonapp.network.responses.VersionGroupDetail

object FakeApiDataSource {

    private val fakeApiPokemonList = ApiPokemonList(
        count = 4, next = "", previous = "", results = listOf(
            Result(name = "Bulbasaur", url = "https://pokeapi.co/api/v2/pokemon/1/"),
            Result(name = "Charmander", url = "https://pokeapi.co/api/v2/pokemon/4/"),
            Result(name = "Squirtle", url = "https://pokeapi.co/api/v2/pokemon/7/"),
            Result(name = "Pikachu", url = "https://pokeapi.co/api/v2/pokemon/25/")
        )
    )

    fun getFakePokemonList(): ApiPokemonList {
        return fakeApiPokemonList
    }

    fun getPokemon(): Pokemon{
        return pokemon
    }
    private val pokemon = Pokemon(
        name = "Bulbasaur", pokedexIndex = 1, height = 7.0,weight = 69.0, types = listOf(
            "grass", "poison"
        ), abilities = listOf(
            "overgrow", "chlorophyll"
        ), moves = listOf(
            "razor-wind", "swords-dance"
        )
    )

    fun getFakePokemon(name: String): ApiPokemon {
        when (name) {
            "Bulbasaur" -> return fakePokemon[0]
            "Charmander" -> return fakePokemon[1]
            "Squirtle" -> return fakePokemon[2]
        }
        return fakePokemon[0]
    }

    private val fakePokemon = listOf(
        ApiPokemon(
            id = 1, name = "Bulbasaur", height = 7.0, weight = 69.0, types = listOf(
                Type(
                    slot = 1, type = TypeX(
                        name = "grass", url = "https://pokeapi.co/api/v2/type/12/"
                    )
                ), Type(
                    slot = 2, type = TypeX(
                        name = "poison", url = "https://pokeapi.co/api/v2/type/4/"
                    )
                )
            ), abilities = listOf(
                Ability(
                    ability = AbilityX(
                        name = "overgrow", url = "https://pokeapi.co/api/v2/ability/65/"
                    ), isHidden = false, slot = 1
                ), Ability(
                    ability = AbilityX(
                        name = "chlorophyll", url = "https://pokeapi.co/api/v2/ability/34/"
                    ), isHidden = true, slot = 3
                )
            ), moves = listOf(
                Move(
                    move = MoveX(
                        name = "razor-wind", url = "https://pokeapi.co/api/v2/move/13/"
                    ), versionGroupDetails = listOf(
                        VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "gold-silver",
                                url = "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "crystal", url = "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "ruby-sapphire",
                                url = "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "emerald", url = "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ), VersionGroupDetail
                    ) as List<VersionGroupDetail>
                ), Move(
                    move = MoveX(
                        name = "swords-dance", url = "https://pokeapi.co/api/v2/move/14/"
                    ), versionGroupDetails = listOf(
                        VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "gold-silver",
                                url = "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "crystal", url = "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "ruby-sapphire",
                                url = "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "emerald", url = "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ), VersionGroupDetail
                    ) as List<VersionGroupDetail>
                )
            )
        ), ApiPokemon(
            id = 4, name = "Squirtle", height = 7.0, weight = 69.0, types = listOf(
                Type(
                    slot = 1, type = TypeX(
                        name = "grass", url = "https://pokeapi.co/api/v2/type/12/"
                    )
                ), Type(
                    slot = 2, type = TypeX(
                        name = "poison", url = "https://pokeapi.co/api/v2/type/4/"
                    )
                )
            ), abilities = listOf(
                Ability(
                    ability = AbilityX(
                        name = "overgrow", url = "https://pokeapi.co/api/v2/ability/65/"
                    ), isHidden = false, slot = 1
                ), Ability(
                    ability = AbilityX(
                        name = "chlorophyll", url = "https://pokeapi.co/api/v2/ability/34/"
                    ), isHidden = true, slot = 3
                )
            ), moves = listOf(
                Move(
                    move = MoveX(
                        name = "razor-wind", url = "https://pokeapi.co/api/v2/move/13/"
                    ), versionGroupDetails = listOf(
                        VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "gold-silver",
                                url = "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "crystal", url = "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "ruby-sapphire",
                                url = "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "emerald", url = "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ), VersionGroupDetail
                    ) as List<VersionGroupDetail>
                ), Move(
                    move = MoveX(
                        name = "swords-dance", url = "https://pokeapi.co/api/v2/move/14/"
                    ), versionGroupDetails = listOf(
                        VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "gold-silver",
                                url = "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "crystal", url = "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "ruby-sapphire",
                                url = "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "emerald", url = "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ), VersionGroupDetail
                    ) as List<VersionGroupDetail>
                )
            )
        ), ApiPokemon(
            id = 7, name = "Charmander", height = 7.0, weight = 69.0, types = listOf(
                Type(
                    slot = 4, type = TypeX(
                        name = "grass", url = "https://pokeapi.co/api/v2/type/12/"
                    )
                ), Type(
                    slot = 2, type = TypeX(
                        name = "poison", url = "https://pokeapi.co/api/v2/type/4/"
                    )
                )
            ), abilities = listOf(
                Ability(
                    ability = AbilityX(
                        name = "overgrow", url = "https://pokeapi.co/api/v2/ability/65/"
                    ), isHidden = false, slot = 1
                ), Ability(
                    ability = AbilityX(
                        name = "chlorophyll", url = "https://pokeapi.co/api/v2/ability/34/"
                    ), isHidden = true, slot = 3
                )
            ), moves = listOf(
                Move(
                    move = MoveX(
                        name = "razor-wind", url = "https://pokeapi.co/api/v2/move/13/"
                    ), versionGroupDetails = listOf(
                        VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "gold-silver",
                                url = "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "crystal", url = "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "ruby-sapphire",
                                url = "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "emerald", url = "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ), VersionGroupDetail
                    ) as List<VersionGroupDetail>
                ), Move(
                    move = MoveX(
                        name = "swords-dance", url = "https://pokeapi.co/api/v2/move/14/"
                    ), versionGroupDetails = listOf(
                        VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "gold-silver",
                                url = "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "crystal", url = "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "ruby-sapphire",
                                url = "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ), VersionGroupDetail(
                            levelLearnedAt = 0, moveLearnMethod = MoveLearnMethod(
                                name = "egg", url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ), versionGroup = VersionGroup(
                                name = "emerald", url = "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ), VersionGroupDetail
                    ) as List<VersionGroupDetail>
                )
            )
        )
    )

    private val fakeDbPokemonList = listOf(
        PokemonList(
            name = "Charizard", pokedexIndex = 3, isCatched = true
        ), PokemonList(
            name = "Butterfree", pokedexIndex = 12, isCatched = true
        )
    )


    fun getFakeDbPokemonList(): List<PokemonList> {
        return fakeDbPokemonList
    }

    fun getFakePokmeonListYourTeam() : List<DbPokemonList> {
        return listOf(
            DbPokemonList(
                name = "Charizard", pokedexIndex = 3, isCatched = true
            ), DbPokemonList(
                name = "Butterfree", pokedexIndex = 12, isCatched = true
            )
        )
    }



    fun getFakePokemonListBubla(): PokemonList {
        return PokemonList(name = "Bulbasaur", pokedexIndex = 1, isCatched = false)


    }

}



