import React, { useState } from 'react';

import { NavDropdown, Container, Row, Col, ListGroup } from 'react-bootstrap';

const subjects = ['Math', 'Science', 'History', 'Literature'];

const courses = [
  { subject: 'Math', name: 'Calculus 101' },
  { subject: 'Math', name: 'Linear Algebra' },
  { subject: 'Science', name: 'Biology 101' },
  { subject: 'Science', name: 'Chemistry 101' },
  { subject: 'History', name: 'World History' },
  { subject: 'Literature', name: 'English Literature' },
];

function CourseMenu() {
  const [selectedSubject, setSelectedSubject] = useState('');
  const [filteredCourses, setFilteredCourses] = useState([]);

  const handleSubjectSelect = (subject) => {
    setSelectedSubject(subject);
    setFilteredCourses(courses.filter((course) => course.subject === subject));
  };

  return (
    <Container className="p-5 border">
      <Row>
        <Col md={4} className="mb-3">
          <h2>Select a Subject</h2>
          <NavDropdown
            title={selectedSubject || 'Select Subject'}
            onSelect={handleSubjectSelect}
            className="mb-3"
          >
            {subjects.map((subject) => (
              <NavDropdown.Item key={subject} eventKey={subject}>
                {subject}
              </NavDropdown.Item>
            ))}
          </NavDropdown>
        </Col>
        <Col md={8}>
          <h2>Available Courses</h2>
          {filteredCourses.length > 0 ? (
            <ListGroup>
              {filteredCourses.map((course) => (
                <ListGroup.Item key={course.name} className="text-center">
                  {course.name}
                </ListGroup.Item>
              ))}
            </ListGroup>
          ) : (
            <p className="text-muted">Select a subject to view courses.</p>
          )}
        </Col>
      </Row>
    </Container>
  );
}

export default CourseMenu;
