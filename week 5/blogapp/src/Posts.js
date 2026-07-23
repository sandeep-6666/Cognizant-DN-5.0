
import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: []
    };
  }

  // Step 6: loadPosts() using Fetch API
  loadPosts() {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        const postList = data.map(
          (item) => new Post(item.id, item.title, item.body)
        );
        this.setState({ posts: postList });
      })
      .catch((error) => {
        console.error('Error fetching posts:', error);
      });
  }

  // Step 7: componentDidMount() hook
  componentDidMount() {
    this.loadPosts();
  }

  // Step 9: componentDidCatch() hook
  componentDidCatch(error, info) {
    alert('An error occurred: ' + error.toString());
  }

  // Step 8: render() method
  render() {
    return (
      <div>
        <h1>Blog Posts</h1>
        {this.state.posts.map((post) => (
          <div key={post.id}>
            <h2>{post.title}</h2>
            <p>{post.body}</p>
          </div>
        ))}
      </div>
    );
  }
}

export default Posts;