package com.jocker.jlife

import androidx.lifecycle.MutableLiveData
import org.junit.Test

import com.jocker.jlife.db.SubjectBean
import com.jocker.jlife.net.NetManager
import com.jocker.jlife.ui.main.MainRepository
import com.jocker.jlife.ui.main.MovieViewModel

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class MainViewModelTest {
    @Test
    fun addition_isCorrect() {
        val mainRepository = MainRepository.get()
        val viewModel = MovieViewModel(mainRepository)
        val inTheaterMovies = viewModel.getInTheaterMovies()
    }
    @Test
    fun getInTheaterMovies(){
        val instanse = NetManager.getInstance()
        val mutableListOf = mutableListOf<SubjectBean>()
        val sub:MutableLiveData<MutableList<SubjectBean>> = MutableLiveData()
//        val movieInTheater = instanse.getMovieInTheater(sub, mutableList)
    }
}