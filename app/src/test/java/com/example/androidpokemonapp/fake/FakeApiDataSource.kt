package com.example.androidpokemonapp.fake

import com.example.androidpokemonapp.model.PokemonList
import com.example.androidpokemonapp.network.responses.ApiPokemon
import com.example.androidpokemonapp.network.responses.ApiPokemonList
import com.example.androidpokemonapp.network.responses.Move
import com.example.androidpokemonapp.network.responses.MoveLearnMethod
import com.example.androidpokemonapp.network.responses.MoveX
import com.example.androidpokemonapp.network.responses.Result
import com.example.androidpokemonapp.network.responses.Type
import com.example.androidpokemonapp.network.responses.VersionGroup
import com.example.androidpokemonapp.network.responses.VersionGroupDetail
import com.example.androidpokemonapp.network.responses.asDomainObject

object FakeApiDataSource {

    private val fakeApiPokemonList =
        ApiPokemonList(
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

    fun getFakePokemon(name : String): ApiPokemon {
        when(name){
            "Bulbasaur" -> return fakeApiPokemon[0]
            "Charmander" -> return fakeApiPokemon[1]
            "Squirtle" -> return fakeApiPokemon[2]
        }
       return fakeApiPokemon[0]
    }

    private val fakeApiPokemon = listOf(
        ApiPokemon(
            id = 1,
            name = "Bulbasaur",
            height = 7.0,
            weight = 69.0,
            types = listOf(
                Type(
                    slot = 1,
                    type = com.example.androidpokemonapp.network.responses.TypeX(
                        name = "grass",
                        url = "https://pokeapi.co/api/v2/type/12/"
                    )
                ),
                Type(
                    slot = 2,
                    type = com.example.androidpokemonapp.network.responses.TypeX(
                        name = "poison",
                        url = "https://pokeapi.co/api/v2/type/4/"
                    )
                )
            ),
            abilities = listOf(
                com.example.androidpokemonapp.network.responses.Ability(
                    ability = com.example.androidpokemonapp.network.responses.AbilityX(
                        name = "overgrow",
                        url = "https://pokeapi.co/api/v2/ability/65/"
                    ),
                    is_hidden = false,
                    slot = 1
                ),
                com.example.androidpokemonapp.network.responses.Ability(
                    ability = com.example.androidpokemonapp.network.responses.AbilityX(
                        name = "chlorophyll",
                        url = "https://pokeapi.co/api/v2/ability/34/"
                    ),
                    is_hidden = true,
                    slot = 3
                )
            ),
            moves = listOf(
                com.example.androidpokemonapp.network.responses.Move(
                    move = com.example.androidpokemonapp.network.responses.MoveX(
                        name = "razor-wind",
                        url = "https://pokeapi.co/api/v2/move/13/"
                    ),
                    version_group_details = listOf(
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "gold-silver",
                                url = "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "crystal",
                                url = "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "ruby-sapphire",
                                url = "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "emerald",
                                url = "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ),
                        VersionGroupDetail
                    ) as List<VersionGroupDetail>
                ),
                Move(
                    move = MoveX(
                        name = "swords-dance",
                        url = "https://pokeapi.co/api/v2/move/14/"
                    ),
                    version_group_details = listOf(
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "gold-silver",
                                url = "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "crystal",
                                url = "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "ruby-sapphire",
                                url = "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "emerald",
                                url = "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ),
                        VersionGroupDetail
                    ) as List<VersionGroupDetail>
                )
            )
        ),
        ApiPokemon(
            id = 4,
            name = "Squirtle",
            height = 7.0,
            weight = 69.0,
            types = listOf(
                Type(
                    slot = 1,
                    type = com.example.androidpokemonapp.network.responses.TypeX(
                        name = "grass",
                        url = "https://pokeapi.co/api/v2/type/12/"
                    )
                ),
                Type(
                    slot = 2,
                    type = com.example.androidpokemonapp.network.responses.TypeX(
                        name = "poison",
                        url = "https://pokeapi.co/api/v2/type/4/"
                    )
                )
            ),
            abilities = listOf(
                com.example.androidpokemonapp.network.responses.Ability(
                    ability = com.example.androidpokemonapp.network.responses.AbilityX(
                        name = "overgrow",
                        url = "https://pokeapi.co/api/v2/ability/65/"
                    ),
                    is_hidden = false,
                    slot = 1
                ),
                com.example.androidpokemonapp.network.responses.Ability(
                    ability = com.example.androidpokemonapp.network.responses.AbilityX(
                        name = "chlorophyll",
                        url = "https://pokeapi.co/api/v2/ability/34/"
                    ),
                    is_hidden = true,
                    slot = 3
                )
            ),
            moves = listOf(
                com.example.androidpokemonapp.network.responses.Move(
                    move = com.example.androidpokemonapp.network.responses.MoveX(
                        name = "razor-wind",
                        url = "https://pokeapi.co/api/v2/move/13/"
                    ),
                    version_group_details = listOf(
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "gold-silver",
                                url = "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "crystal",
                                url = "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "ruby-sapphire",
                                url = "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "emerald",
                                url = "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ),
                        VersionGroupDetail
                    ) as List<VersionGroupDetail>
                ),
                Move(
                    move = MoveX(
                        name = "swords-dance",
                        url = "https://pokeapi.co/api/v2/move/14/"
                    ),
                    version_group_details = listOf(
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "gold-silver",
                                url = "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "crystal",
                                url = "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "ruby-sapphire",
                                url = "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "emerald",
                                url = "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ),
                        VersionGroupDetail
                    ) as List<VersionGroupDetail>
                )
            )
        ),
        ApiPokemon(
            id = 7,
            name = "Charmander",
            height = 7.0,
            weight = 69.0,
            types = listOf(
                Type(
                    slot = 4,
                    type = com.example.androidpokemonapp.network.responses.TypeX(
                        name = "grass",
                        url = "https://pokeapi.co/api/v2/type/12/"
                    )
                ),
                Type(
                    slot = 2,
                    type = com.example.androidpokemonapp.network.responses.TypeX(
                        name = "poison",
                        url = "https://pokeapi.co/api/v2/type/4/"
                    )
                )
            ),
            abilities = listOf(
                com.example.androidpokemonapp.network.responses.Ability(
                    ability = com.example.androidpokemonapp.network.responses.AbilityX(
                        name = "overgrow",
                        url = "https://pokeapi.co/api/v2/ability/65/"
                    ),
                    is_hidden = false,
                    slot = 1
                ),
                com.example.androidpokemonapp.network.responses.Ability(
                    ability = com.example.androidpokemonapp.network.responses.AbilityX(
                        name = "chlorophyll",
                        url = "https://pokeapi.co/api/v2/ability/34/"
                    ),
                    is_hidden = true,
                    slot = 3
                )
            ),
            moves = listOf(
                com.example.androidpokemonapp.network.responses.Move(
                    move = com.example.androidpokemonapp.network.responses.MoveX(
                        name = "razor-wind",
                        url = "https://pokeapi.co/api/v2/move/13/"
                    ),
                    version_group_details = listOf(
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "gold-silver",
                                url = "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "crystal",
                                url = "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "ruby-sapphire",
                                url = "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "emerald",
                                url = "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ),
                        VersionGroupDetail
                    ) as List<VersionGroupDetail>
                ),
                Move(
                    move = MoveX(
                        name = "swords-dance",
                        url = "https://pokeapi.co/api/v2/move/14/"
                    ),
                    version_group_details = listOf(
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "gold-silver",
                                url = "https://pokeapi.co/api/v2/version-group/3/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "crystal",
                                url = "https://pokeapi.co/api/v2/version-group/4/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "ruby-sapphire",
                                url = "https://pokeapi.co/api/v2/version-group/5/"
                            )
                        ),
                        VersionGroupDetail(
                            level_learned_at = 0,
                            move_learn_method = MoveLearnMethod(
                                name = "egg",
                                url = "https://pokeapi.co/api/v2/move-learn-method/2/"
                            ),
                            version_group = VersionGroup(
                                name = "emerald",
                                url = "https://pokeapi.co/api/v2/version-group/6/"
                            )
                        ),
                        VersionGroupDetail
                    ) as List<VersionGroupDetail>
                )
            )
        )
    )

    private val fakeDbPokemonList = listOf(
        PokemonList(
            name = "Charizard",
            pokedexIndex = 3,
            isCatched = true
        ),
        PokemonList(
            name = "Butterfree",
            pokedexIndex = 12,
            isCatched = true
        )
    )


    fun getFakeDbPokemonList(): List<PokemonList> {
        return fakeDbPokemonList
    }
}


