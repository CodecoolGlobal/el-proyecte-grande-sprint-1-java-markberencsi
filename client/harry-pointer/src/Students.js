

const Students = ({students}) => {
    return (
        <ol>
            <> {students.map(student => <li>{student.firstName} {student.lastName} {student.email}</li>)}</>
        </ol>
    )
}

export default Students