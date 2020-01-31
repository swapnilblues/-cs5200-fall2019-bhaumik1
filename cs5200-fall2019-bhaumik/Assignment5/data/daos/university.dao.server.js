const studentModel = require('../models/student.model.server');
const questionModel = require('../models/question.model.server');
const answerModel = require('../models/answer.model.server');

createStudent = student => studentModel.create(student);

updateStudent = (studentId, student) => studentModel.update({_id: studentId}, {$set: student});
deleteStudent = studentId => studentModel.deleteOne({_id: studentId});

createQuestion = question => questionModel.create(question);
createAnswer = answer => answerModel.create(answer);
deleteQuestion = question => questionModel.deleteOne({_id: question});
answerQuestion =
    (studentId, questionId, answer) => answer.create(
        {student: studentId, question: questionId, answer: answer});
deleteAnswer = id => answerModel.deleteOne({_id: id});
deleteAnswerByQuestionAndStudent = (studentId, questionId) => answerModel.deleteOne({
                                                                                        student: studentId,
                                                                                        question: questionId
                                                                                    });

findAllStudents = () => studentModel.find();
findStudentById = studentId => studentModel.findById(studentId);
findAllQuestions = () => questionModel.find();
findQuestionById = questionId => questionModel.findById(questionId);
findAllAnswers = () => answerModel.find();
findAnswerById = answerId => answerModel.findById(answerId);
findAnswersByStudent = studentId => answerModel.find({student: studentId});
findAnswersByQuestion = questionId => questionModel.find({question: questionId});



truncateDatabase =
    () => answerModel.deleteMany().then(() => questionModel.deleteMany())
        .then(() => studentModel.deleteMany());
populateDatabase = () => createStudent(
    {
        '_id': 123,
        'username': 'alice',
        'password': 'alice',
        'firstName': 'Alice',
        'lastName': 'Wonderland',
        'gradYear': 2020,
        'scholarship': 15000,
    }
).then(() => createStudent(
    {
        '_id': 234,
        'username': 'bob',
        'password': 'alice',
        'firstName': 'Bob',
        'lastName': 'Hope',
        'gradYear': 2021,
        'scholarship': 12000,
    }
).then(() => createQuestion(
    {
        '_id': 321,
        'Question': 'Is the following schema valid',
        'Points': 10,
        'questionType': 'TRUE_FALSE',
        'trueFalse': {
            'isTrue': false
        },
    }
).then(() => createQuestion(
    {
        '_id': 432,
        'Question': 'DAO stands for Dynamic Access Object',
        'Points': 10,
        'questionType': 'TRUE_FALSE',
        'trueFalse': {
            'isTrue': false
        },

    }
).then(() => createQuestion(
    {
        '_id': 543,
        'Question': 'What does JPA stand for?',
        'Points': 10,
        'questionType': 'MULTIPLE_CHOICE',
        'multipleChoice': {
            'choices': 'Java Persistence API,Java Persisted'
                       + ' Application,JavaScript Persistence API,'
                       + 'JSON Persistent Associations',
            'correct': 1
        },
    }
).then(() => createQuestion(
    {
        '_id': 654,
        'Question': 'What does ORM stand for?',
        'Points': 10,
        'questionType': 'MULTIPLE_CHOICE',
        'multipleChoice': {
            'choices': 'Object Relational Model,'
                       + 'Object Relative Markup,Object Reflexive Model,'
                       + 'Object Relational Mapping',
            'correct': 4
        },
    }
).then(() => createAnswer(
    {
        '_id': 123,
        'student': 123,
        'question': 321,
        'trueFalseAnswer': true
    }
).then(() => createAnswer(
    {
        '_id': 234,
        'student': 123,
        'question': 432,
        'trueFalseAnswer': false
    }
).then(() => createAnswer(
    {
        '_id': 345,
        'student': 123,
        'question': 543,
        'multipleChoiceAnswer': 1
    }
).then(() => createAnswer(
    {
        '_id': 456,
        'student': 123,
        'question': 654,
        'multipleChoiceAnswer': 2
    }
).then(() => createAnswer(
    {
        '_id': 567,
        'student': 234,
        'question': 321,
        'trueFalseAnswer': false
    }
).then(() => createAnswer(
    {
        '_id': 678,
        'student': 234,
        'question': 432,
        'trueFalseAnswer': true
    }
).then(() => createAnswer(
    {
        '_id': 789,
        'student': 234,
        'question': 543,
        'multipleChoiceAnswer': 3
    }
).then(() => createAnswer(
    {
        '_id': 890,
        'student': 234,
        'question': 654,
        'multipleChoiceAnswer': 4
    }
))))))))))))));

module.exports = {
    truncateDatabase, populateDatabase, deleteStudent, deleteQuestion, answerQuestion, deleteAnswer,
    findAllStudents, findAllQuestions, findQuestionById, findAllAnswers, findAnswerById, findAnswersByStudent,
     deleteAnswerByQuestionAndStudent
};