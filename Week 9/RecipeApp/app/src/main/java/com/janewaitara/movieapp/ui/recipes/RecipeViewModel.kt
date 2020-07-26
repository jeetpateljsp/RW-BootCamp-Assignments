package com.janewaitara.movieapp.ui.recipes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.janewaitara.movieapp.model.Recipe
import com.janewaitara.movieapp.repository.RoomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeViewModel(  private val repository: RoomRepository = RoomRepository()): ViewModel() {


    /**Using LiveData has several benefits:
    We can put an observer on the data (instead of polling for changes) and only update the
    the UI when the data actually changes.
    Repository is completely separated from the UI through the ViewModel.
     */

    /**LiveData member variable to cache the list of recipes*/
    val allRecipes: LiveData<List<Recipe>> = repository.getAllRecipes()

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */

    fun insertRecipes(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAllRecipes()
        }
    }

}