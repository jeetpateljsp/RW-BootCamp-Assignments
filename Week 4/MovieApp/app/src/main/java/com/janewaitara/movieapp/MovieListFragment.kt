package com.janewaitara.movieapp

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MovieListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment(), MovieAdapter.MovieListClickListener {

    private var listener: OnFragmentInteractionListener? = null
    private lateinit var movieRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieRecyclerView = view.findViewById(R.id.movieRecyclerView)
        movieRecyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        movieRecyclerView.adapter = MovieAdapter(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */

    interface OnFragmentInteractionListener {
        fun onMovieListClicked(movie: Movie)
    }

    companion object {

        fun newInstance():MovieListFragment{
            return  MovieListFragment()
        }
    }

    /***when a view is tapped, this method is called it notifies the listener(activity) that something has happened **/
    override fun movieItemClicked(movie: Movie) {
        listener?.onMovieListClicked(movie)
    }
}