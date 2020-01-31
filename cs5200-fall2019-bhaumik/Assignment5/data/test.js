require('jest');
require('./db')();
const universityDao = require('./daos/university.dao.server');


beforeAll(async () => {
              await universityDao.truncateDatabase();
              await universityDao.populateDatabase();

          }
);

test('testStudentsInitialCount', async () => {
    await universityDao.findAllStudents().then(
        students => {
            expect(students.length).toBe(2)
        }
    )
});

test('testQuestionsInitialCount', async () => {
    await universityDao.findAllQuestions().then(
        questions => {
            expect(questions.length).toBe(4)
        }
    )
});

test('testAnswersInitialCount', async () => {
    await universityDao.findAllAnswers().then(
        answers => {
            expect(answers.length).toBe(8)
        }
    )
});

test('testDeleteAnswer', async () => {
    await universityDao.deleteAnswerByQuestionAndStudent(234, 654)
        .then(() => universityDao.findAllAnswers().count({})
                  .then(answerCount => expect(answerCount).toBe(7),
              universityDao.findAnswersByStudent(234).count({})
                  .then(answerByBobCount =>
                      expect(answerByBobCount).toBe(3)
                  )))
});

test('testDeleteQuestion', async () => {
    await universityDao.deleteQuestion(321)
        .then(() => universityDao.findAllQuestions().count({})
            .then(questionCount => expect(questionCount).toBe(3)
                      ))
});

test('testDeleteStudent', async () => {
    await universityDao.deleteStudent(234)
        .then(() => universityDao.findAllStudents().count({})
            .then(studentCount => expect(studentCount).toBe(1)
            ))
});

