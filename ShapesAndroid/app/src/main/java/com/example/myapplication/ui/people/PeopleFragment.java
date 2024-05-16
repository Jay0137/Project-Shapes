package com.example.myapplication.ui.people;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.User;

import java.util.ArrayList;
import java.util.List;

public class PeopleFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<User> userList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_people, container, false);

        // Initialize RecyclerView
       // recyclerView = rootView.findViewById(R.id.recyclerViewPeople);
       // recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Fetch user data (this is just a dummy implementation)
      //  fetchUserData();

        // Populate RecyclerView with user data
       // UserAdapter adapter = new UserAdapter(userList);
       // recyclerView.setAdapter(adapter);

        return rootView;
    }

    // Dummy method to fetch user data (replace with your actual implementation)
    private void fetchUserData() {
        userList = new ArrayList<>();
        // Fetch user data from the database and add to userList
        // For demonstration, I'm adding dummy users here
        userList.add(new User(1, "John Doe", "john@example.com"));
        userList.add(new User(2, "Jane Smith", "jane@example.com"));
        // Add more users as needed
    }
}
