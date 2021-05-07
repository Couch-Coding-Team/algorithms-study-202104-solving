var reconstructQueue = function (people) {
  const answer = [];

  people.sort((a, b) => a[1] - b[1] || a[0] - b[0]);

  people.forEach((p) => {
    let count = 0,
      i = 0;
    for (; i < answer.length; i++) {
      if (answer[i][0] >= p[0]) count++;
      if (count > p[1]) break;
    }

    answer.splice(i, 0, p);
  });

  return answer;
};
