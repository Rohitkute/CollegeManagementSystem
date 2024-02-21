import './Menus.css';
import React from "react";
import { ListGroup, ListGroupItem } from "react-bootstrap";
import { Link } from "react-router-dom"; // Import Link from React Router

const Menus = () => {
  const menuItems = [
    { name: "Home", link: "/" }, // Use React Router paths
    { name: "Coursemenu", link: "/coursesmenu" },
    
    { name: "Login", link: "/Login" },
    { name: "Result", link: "/result" },
    { name: "Login", link: "/Login" },
    { name: "Course", link: "/Course" },



  ];

  return (
    <ListGroup className="menu-list">
      {menuItems.map((item, index) => (
        <ListGroupItem key={index} as={Link} to={item.link} action aria-label={item.name}>
          {item.name}
        </ListGroupItem>
      ))}
    </ListGroup>
  );
};

export default Menus;

