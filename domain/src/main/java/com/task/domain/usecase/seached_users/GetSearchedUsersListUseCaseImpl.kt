package com.task.domain.usecase.seached_users

import com.task.domain.model.user.UserItem

internal class GetSearchedUsersListUseCaseImpl : GetSearchedUsersListUseCase {
    override suspend fun invoke(searchText: String, fullList: List<UserItem>): List<UserItem> =
        fullList
            .filter {
                it.name.contains(searchText, true) ||
                        it.phone.contains(searchText, true) ||
                        it.location.street.name.contains(searchText, true) ||
                        it.location.street.number.toString().contains(searchText, true) ||
                        it.location.city.contains(searchText, true) ||
                        it.location.country.contains(searchText, true)
            }
}