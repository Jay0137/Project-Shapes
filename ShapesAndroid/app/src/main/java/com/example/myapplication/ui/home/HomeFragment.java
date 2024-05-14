package com.example.myapplication.ui.home;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {
    /*

    private List<Post> postList;
    private PostAdapter postAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize RecyclerView
        RecyclerView recyclerView = root.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Initialize PostAdapter and set it to RecyclerView
        postList = new ArrayList<>();
        postAdapter = new PostAdapter(postList);
        recyclerView.setAdapter(postAdapter);

        // Fetch posts and update the adapter
        fetchPosts();

        return root;
    }

    private void fetchPosts() {
        // You need to implement the logic to fetch posts from your database or backend
        // For example, if you have a PostDAO class to fetch posts from the database:
        PostDAO postDAO = new PostDAO(getActivity());
        postDAO.open();
        postList.addAll(postDAO.getAllPosts()); // Assuming getAllPosts() returns a list of posts
        postDAO.close();

        // Notify the adapter that the dataset has changed
        postAdapter.notifyDataSetChanged();
    }
    */
}
